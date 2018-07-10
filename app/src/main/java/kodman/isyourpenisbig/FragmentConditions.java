package kodman.isyourpenisbig;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class FragmentConditions extends Fragment implements View.OnClickListener,View.OnKeyListener {
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
       // Log.d("---"," "+i+" | "+KeyEvent.keyCodeToString(i));
        if(i==KeyEvent.KEYCODE_ENTER)
        {
         //   Log.d("---","ENTER  "+i+" | "+KeyEvent.keyCodeToString(i));
            //btnRes.setFocusable(true);
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
            avLength=Double.parseDouble(etPeople.getText().toString());
        }

        return false;
    }

    Spinner spinner;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
Log.d("---","onActivtiyuResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("---","onResume");
        if(flag)
        {
            flag=false;
            initScreenRes();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initScreenRes() {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentResultat fResultat= new FragmentResultat();
        fragmentTransaction.add(R.id.fragLayout,fResultat);
        fResultat.setResultat(50.50);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    private void showAd(){

        Log.d("---", "Show AD");
        if (mInterstitialAd.isLoaded()) {

            mInterstitialAd.show();
        } else {
            Log.d("---", "The interstitial wasn't loaded yet.");
        }
    }
    @Override
    public void onClick(View view) {

        Log.d("---","Click"+view);

        switch (view.getId()) {

            case R.id.btnRes:

                showAd();
                //initScreenRes();
                break;


            case R.id.ibFootBig:
                setCheked(ibFootBig, ibFootMiddle, ibFootSmall);
                break;
            case R.id.ibFootMiddle:
                setCheked(ibFootMiddle, ibFootBig, ibFootSmall);
                break;
            case R.id.ibFootSmall:
                setCheked(ibFootSmall, ibFootBig, ibFootMiddle);
                break;

            case R.id.ibNoseBig:
                setCheked(ibNoseBig, ibNoseMiddle, ibNoseSmall);
                break;
            case R.id.ibNoseMiddle:
                setCheked(ibNoseMiddle, ibNoseBig, ibNoseSmall);
                break;
            case R.id.ibNoseSmall:
                setCheked(ibNoseSmall, ibNoseMiddle, ibNoseBig);
                break;

            case R.id.ibPeopleBig:

                setCheked(ibPeopleBig, ibPeopleMiddle, ibPeopleSmall);
                break;
            case R.id.ibPeopleMiddle:

                setCheked(ibPeopleMiddle, ibPeopleBig, ibPeopleSmall);
                break;
            case R.id.ibPeopleSmall:
                setCheked(ibPeopleSmall, ibPeopleMiddle, ibPeopleBig);
                break;

            case R.id.ibHandBig:
                setCheked(ibHandBig, ibHandMiddle, ibHandSmall);
                break;
            case R.id.ibHandMiddle:
                setCheked(ibHandMiddle, ibHandBig, ibHandSmall);
                break;
            case R.id.ibHandSmall:
                setCheked(ibHandSmall, ibHandBig, ibHandMiddle);
                break;
        }
    }



    final short CHECKED = 1;
    final short UNCHECKED = 0;

    EditText etPeople;
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

//For ADMOB
    InterstitialAd mInterstitialAd;

    public class SpinnerAdapter extends ArrayAdapter<String> {
        private Context mContext;
        private String[] list;










        public SpinnerAdapter(Context c, int textViewResourceId, String[] list) {
            super(c, textViewResourceId, list);
            mContext = c;
            this.list = list;
        }

        public int getCount() {
            return list.length;
        }


        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View row = inflater.inflate(R.layout.spin_dropdown, parent, false);
            TextView label = (TextView) row.findViewById(R.id.tv);
            setText(position, label);
            return row;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity(). getLayoutInflater();
            View row = inflater.inflate(R.layout.spin, parent, false);

            TextView label = (TextView) row.findViewById(R.id.tv);
            setText(position, label);
            return row;
        }

        public void setText(int position, TextView label) {

            String[] ss = list[position].split("[|]");
            //Log.d("---", "[] country = "+ss[0]+"   "  +ss[1]);
            avLength = Double.valueOf(ss[1]);
            // Log.d("---", " country = "+country+"   "  +avLength);
            label.setText(ss[0]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.screen_conditions, null);
etPeople=view.findViewById(R.id.etPeople);
etPeople.setOnKeyListener(this);
                spinner = view.findViewById(R.id.spinner);
        String[] countries = getResources().getStringArray(R.array.countries);
        SpinnerAdapter adapter = new SpinnerAdapter( getActivity(), R.id.tv, countries);
        adapter.setDropDownViewResource(R.layout.spin_dropdown);

        spinner.setAdapter(adapter);


        ibPeopleBig=view.findViewById(R.id.ibPeopleBig);
        ibPeopleMiddle=view.findViewById(R.id.ibPeopleMiddle);
        ibPeopleSmall=view.findViewById(R.id.ibPeopleSmall);

        ibNoseBig=view.findViewById(R.id.ibNoseBig);
        ibNoseMiddle=view.findViewById(R.id.ibNoseMiddle);
        ibNoseSmall=view.findViewById(R.id.ibNoseSmall);

        ibFootBig=view.findViewById(R.id.ibFootBig);
        ibFootMiddle=view.findViewById(R.id.ibFootMiddle);
        ibFootSmall=view.findViewById(R.id.ibFootSmall);

        ibHandBig=view.findViewById(R.id.ibHandBig);
        ibHandMiddle=view.findViewById(R.id.ibHandMiddle);
        ibHandSmall=view.findViewById(R.id.ibHandSmall);

        btnRes=view.findViewById(R.id.btnRes);
        setClickListener();

//AdMob

       mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getActivity().getResources().getString(R.string.ad_unit_id_interstitial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
               // Log.d("---","Loaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
               // Toast.makeText(getActivity().getBaseContext(),"  Failed AD:"+errorCode,Toast.LENGTH_SHORT).show();
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                //Toast.makeText(getActivity().getBaseContext(),"  Opened AD",Toast.LENGTH_SHORT).show();
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
              //  Toast.makeText(getActivity().getBaseContext(),"  LeftApp AD",Toast.LENGTH_SHORT).show();
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                flag=true;
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
              //  initScreenRes();
               // Toast.makeText(getActivity().getBaseContext(),"  Closed AD",Toast.LENGTH_SHORT).show();
                // Code to be executed when when the interstitial ad is closed.
            }

        });
        return view;
    }

    boolean flag=false;
    private void setClickListener() {
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

        btnRes.setOnClickListener(this);
    }


    private void setCheked(ImageButton ibs, ImageButton ibs1, ImageButton ibs2) {

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            //ibPeopleBig.setBackgroundDrawable(getResources().getDrawable(R.color.colorImageButtonChecked));
            ibs.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked));
        } else {
            //ibPeopleBig.setBackground(getResources().getDrawable(R.color.colorImageButtonChecked));
            // ibPeopleBig.setBackground(getResources().getDrawable(R.drawable.checked));
            ibs.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.checked));
        }
        ibs.setTag(CHECKED);

        if (ibs1.getTag() == null || ((short) ibs1.getTag()) == CHECKED) {
            ibs1.getTag(UNCHECKED);
            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                //noinspection deprecation
                ibs1.setBackgroundDrawable(getResources().getDrawable(R.drawable.unchecked));
            } else {
                ibs1.setBackground(getResources().getDrawable(R.drawable.unchecked));
                //  Log.d("---","draw uncheck : "+ibs1);
            }

        }
        if (ibs2.getTag() == null || ((short) ibs2.getTag()) == CHECKED) {
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
}
