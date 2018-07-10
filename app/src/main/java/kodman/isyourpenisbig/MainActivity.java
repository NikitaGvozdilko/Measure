package kodman.isyourpenisbig;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final short CHECKED = 1;
    final short UNCHECKED = 0;
    final short START = 0;
    final short CONDITIONS = 1;
    final short RESULTAT = 2;

    short status=this.START;

    // @BindView(R.id.imageView)
    ImageView ivStart;

    //    @BindView(R.id.spinner)
    Spinner spinner;

    // @BindView(R.id.ibPeopleBig)
    ImageButton ibPeopleBig;
    // @BindView(R.id.ibPeopleMiddle)
    ImageButton ibPeopleMiddle;
    //@BindView(R.id.ibPeopleSmall)
    ImageButton ibPeopleSmall;

    //@BindView(R.id.ibNoseBig)
    ImageButton ibNoseBig;
    //@BindView(R.id.ibNoseMiddle)
    ImageButton ibNoseMiddle;
    // @BindView(R.id.ibNoseSmall)
    ImageButton ibNoseSmall;

    //@BindView(R.id.ibFootBig)
    ImageButton ibFootBig;
    //@BindView(R.id.ibFootMiddle)
    ImageButton ibFootMiddle;
    //@BindView(R.id.ibFootSmall)
    ImageButton ibFootSmall;

    //@BindView(R.id.ibHandBig)
    ImageButton ibHandBig;
    //@BindView(R.id.ibHandMiddle)
    ImageButton ibHandMiddle;
    //@BindView(R.id.ibHandSmall)
    ImageButton ibHandSmall;
Button btnRes;
    double avLength = 0;


//    private void setCheked(ImageButton ibs, ImageButton ibs1, ImageButton ibs2) {
//
//        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
//            //noinspection deprecation
//            //ibPeopleBig.setBackgroundDrawable(getResources().getDrawable(R.color.colorImageButtonChecked));
//            ibs.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked));
//        } else {
//            //ibPeopleBig.setBackground(getResources().getDrawable(R.color.colorImageButtonChecked));
//            // ibPeopleBig.setBackground(getResources().getDrawable(R.drawable.checked));
//            ibs.setBackground(ContextCompat.getDrawable(this, R.drawable.checked));
//        }
//        ibs.setTag(CHECKED);
//
//        if (ibs1.getTag() == null || ((short) ibs1.getTag()) == CHECKED) {
//            ibs1.getTag(UNCHECKED);
//            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
//                //noinspection deprecation
//                ibs1.setBackgroundDrawable(getResources().getDrawable(R.drawable.unchecked));
//            } else {
//                ibs1.setBackground(getResources().getDrawable(R.drawable.unchecked));
//                //  Log.d("---","draw uncheck : "+ibs1);
//            }
//
//        }
//        if (ibs2.getTag() == null || ((short) ibs2.getTag()) == CHECKED) {
//            ibs2.getTag(UNCHECKED);
//            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
//                //noinspection deprecation
//                ibs2.setBackgroundDrawable(getResources().getDrawable(R.drawable.unchecked));
//            } else {
//                ibs2.setBackground(getResources().getDrawable(R.drawable.unchecked));
//                //  Log.d("---","draw uncheck : "+ibs2);
//            }
//
//        }
//    }

//    public class SpinnerAdapter extends ArrayAdapter<String> {
//        private Context mContext;
//        private String[] list;
//
//        public SpinnerAdapter(Context c, int textViewResourceId, String[] list) {
//            super(c, textViewResourceId, list);
//            mContext = c;
//            this.list = list;
//        }
//
//        public int getCount() {
//            return list.length;
//        }
//
//
//        @Override
//        public View getDropDownView(int position, View convertView,
//                                    ViewGroup parent) {
//            LayoutInflater inflater = getLayoutInflater();
//            View row = inflater.inflate(R.layout.spin_dropdown, parent, false);
//            TextView label = (TextView) row.findViewById(R.id.tv);
//            setText(position, label);
//            return row;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            LayoutInflater inflater = getLayoutInflater();
//            View row = inflater.inflate(R.layout.spin, parent, false);
//
//            TextView label = (TextView) row.findViewById(R.id.tv);
//            setText(position, label);
//            return row;
//        }
//
//        public void setText(int position, TextView label) {
//
//            String[] ss = list[position].split("[|]");
//            //Log.d("---", "[] country = "+ss[0]+"   "  +ss[1]);
//            avLength = Double.valueOf(ss[1]);
//            // Log.d("---", " country = "+country+"   "  +avLength);
//            label.setText(ss[0]);
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("---", "onCreate");
        initScreenStart();

        //Реклама
        MobileAds.initialize(this,getResources().getString(R.string.ad_unit_id));

        com.google.android.gms.ads.AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    private void initScreenStart() {
        status=START;
        setContentView(R.layout.activity_main);
       // setContentView(R.layout.screen_resultat);
        ivStart = this.findViewById(R.id.imageView);
        ivStart.setOnClickListener(this);


    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("---","Resume");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(null!=ivStart&&!ivStart.isClickable())
            ivStart.setClickable(true);
    }

    private void initScreenConditions() {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentConditions fConditions = new FragmentConditions();
        // fTrans = getFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.fragLayout, fConditions);
        fragmentTransaction.addToBackStack(null);
        int n = fragmentTransaction.commit();

        status = CONDITIONS;
        ivStart.setClickable(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.imageView:
                initScreenConditions();
                break;

        }
    }
}
