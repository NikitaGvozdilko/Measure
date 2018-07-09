package kodman.isyourpenisbig;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final short CHECKED=1;
    final short UNCHECKED=0;

    @BindView(R.id.ibPeopleBig)
    ImageButton ibPeopleBig;
    @BindView(R.id.ibPeopleMiddle)
    ImageButton ibPeopleMiddle;
    @BindView(R.id.ibPeopleSmall)
    ImageButton ibPeopleSmall;

    @BindView(R.id.ibNoseBig)
    ImageButton ibNoseBig;
    @BindView(R.id.ibNoseMiddle)
    ImageButton ibNoseMiddle;
    @BindView(R.id.ibNoseSmall)
    ImageButton ibNoseSmall;

    @BindView(R.id.ibFootBig)
    ImageButton ibFootBig;
    @BindView(R.id.ibFootMiddle)
    ImageButton ibFootMiddle;
    @BindView(R.id.ibFootSmall)
    ImageButton ibFootSmall;

    @BindView(R.id.ibHandBig)
    ImageButton ibHandBig;
    @BindView(R.id.ibHandMiddle)
    ImageButton ibHandMiddle;
    @BindView(R.id.ibHandSmall)
    ImageButton ibHandSmall;

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.ibFootBig:
                setCheked(ibFootBig,ibFootMiddle,ibFootSmall);
                break;
            case R.id.ibFootMiddle:
                setCheked(ibFootMiddle,ibFootBig,ibFootSmall);
                break;
            case R.id.ibFootSmall:
                setCheked(ibFootSmall,ibFootBig,ibFootMiddle);
                break;

            case R.id.ibNoseBig:
                setCheked(ibNoseBig,ibNoseMiddle,ibNoseSmall);
                break;
            case R.id.ibNoseMiddle:
                setCheked(ibNoseMiddle,ibNoseBig,ibNoseSmall);
                break;
            case R.id.ibNoseSmall:
                setCheked(ibNoseSmall,ibNoseMiddle,ibNoseBig);
                break;

            case R.id.ibPeopleBig:

                setCheked(ibPeopleBig,ibPeopleMiddle,ibPeopleSmall);
                break;
            case R.id.ibPeopleMiddle:

                setCheked(ibPeopleMiddle,ibPeopleBig,ibPeopleSmall);
                break;
            case R.id.ibPeopleSmall:
                setCheked(ibPeopleSmall,ibPeopleMiddle,ibPeopleBig);
                break;

            case R.id.ibHandBig:
                setCheked(ibHandBig,ibHandMiddle,ibHandSmall);
                break;
            case R.id.ibHandMiddle:
                setCheked(ibHandMiddle,ibHandBig,ibHandSmall);
                break;
            case R.id.ibHandSmall:
                setCheked(ibHandSmall,ibHandBig,ibHandMiddle);
                break;
        }
    }

    private void setCheked(ImageButton ibs,ImageButton ibs1,ImageButton ibs2){

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            //ibPeopleBig.setBackgroundDrawable(getResources().getDrawable(R.color.colorImageButtonChecked));
            ibs.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked));
        } else {
            //ibPeopleBig.setBackground(getResources().getDrawable(R.color.colorImageButtonChecked));
           // ibPeopleBig.setBackground(getResources().getDrawable(R.drawable.checked));
            ibs.setBackground(ContextCompat.getDrawable(this,R.drawable.checked));
        }
        ibs.setTag(CHECKED);

        if(ibs1.getTag()==null||((short)ibs1.getTag())==CHECKED)
        {
            ibs1.getTag(UNCHECKED);
            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                //noinspection deprecation
                ibs1.setBackgroundDrawable(getResources().getDrawable(R.drawable.unchecked));
            } else {
                ibs1.setBackground(getResources().getDrawable(R.drawable.unchecked));
              //  Log.d("---","draw uncheck : "+ibs1);
            }

        }
        if(ibs2.getTag()==null||((short)ibs2.getTag())==CHECKED)
        {
            ibs2.getTag(UNCHECKED);
            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                //noinspection deprecation
                ibs2.setBackgroundDrawable(getResources().getDrawable(R.drawable.unchecked));
            } else {
                ibs2.setBackground(getResources().getDrawable(R.drawable.unchecked));
              //  Log.d("---","draw uncheck : "+ibs2);
            }

        }
    }

//    public class ImageAdapter extends BaseAdapter {
//        private Context mContext;
//
//        public ImageAdapter(Context c) {
//            mContext = c;
//        }
//
//        public int getCount() {
//            return 20;
//        }
//
//        public Object getItem(int position) {
//            return R.drawable.people_icon;
//        }
//
//        public long getItemId(int position) {
//            return position;
//        }
//
//        // create a new ImageView for each item referenced by the Adapter
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView imageView;
//            if (convertView == null) {
//                // if it's not recycled, initialize some attributes
//                imageView = new ImageView(MainActivity.this);
//                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(8, 8, 8, 8);
//            } else {
//                imageView = (ImageView) convertView;
//            }
//
//            imageView.setImageResource(R.drawable.people_icon);
//            return imageView;
//        }
//
//        // references to our images
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.screen_conditions);
        Spinner spinner=this.findViewById(R.id.spinner);
        String[] countries= getResources().getStringArray(R.array.countries);
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spin, R.id.tvCategory,countries){
             @NonNull
             @Override
             public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                 return super.getView(position, convertView, parent);

             }
         };
        adapter.setDropDownViewResource(R.layout.spin_dropdown);


        ButterKnife.bind(this);

        ibPeopleBig.setOnClickListener(this);
        ibPeopleMiddle.setOnClickListener(this);
        ibPeopleSmall.setOnClickListener(this);

        ibNoseBig.setOnClickListener(this);
        ibNoseMiddle.setOnClickListener(this);
        ibNoseSmall.setOnClickListener(this);

        ibFootBig.setOnClickListener(this);
        ibFootMiddle.setOnClickListener(this);
        ibFootSmall.setOnClickListener(this);

        ibHandBig.setOnClickListener(this);
        ibHandMiddle.setOnClickListener(this);
        ibHandSmall.setOnClickListener(this);


      //  if (themeNumber == 1 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        //    spinner.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.spinner_blue));

        spinner.setAdapter(adapter);
//        ImageView iv=this.findViewById(R.id.imageView);
//        TextView tv=this.findViewById(R.id.tvTitle2);
//        View vLine=this.findViewById(R.id.vLine);

       // Log.d("---","onCreate tv Width ="+tv.getLayoutParams().width);

       //ViewGroup.LayoutParams params = vLine.getLayoutParams();
      // params.width = tv.getWidth();
       // vLine.setLayoutParams(params);
        //vLine.setWidth(100);
//        iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("---","click");
//            }
//        });
//
//        MobileAds.initialize(this,
//                "ca-app-pub-3940256099942544~3347511713");
//
//        com.google.android.gms.ads.AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
    }
}
