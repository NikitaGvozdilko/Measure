package kodman.isyourpenisbig;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.google.android.gms.ads.MobileAds;

public class FragmentConditions extends Fragment implements View.OnClickListener, View.OnKeyListener {
    Spinner spinner;

    short[] checks = new short[12];
    int curPositionSpinner;

    float avStature=164;
    float kStature=8;
    float kNose=100;
    float kFoot=15;
    float kHand=100;
    float avLength=0;

    private float measure(){
        Log.d("---","et Stature= "+etPeople.getText().toString());
        if(etPeople.getText()!=null&&!etPeople.getText().toString().equals(""))
        {
            avStature=Float.parseFloat(etPeople.getText().toString());
            kStature=8;
        }
        else
            avStature=164;
        float   resStature=avStature*(kStature/100);
        Log.d("---"," Res Stature = "+resStature);


        Log.d("---","avLength = "+avLength);
        float   resFoot=(avStature*(kFoot/100)+5)/2;
        Log.d("---"," Res Foot = "+resFoot);

        float   resHand=avLength*(kHand/100);
        Log.d("---"," Res Hand = "+resHand);
        float   resNose=avLength*(kNose/100);
        Log.d("---"," Res Nose = "+resNose);
        float   res=(resFoot+resStature+resHand+resNose)/4;
        Log.d("---"," Res = "+res);
   //             res= avStature*(kStature/100);

        //((16% от роста)+5)/2
      //  res=res*(kNose/100);
       // Log.d("---","Nose Res = "+res);
        //res=res*(kHand/100);
        //Log.d("---","Hand Res = "+res);

       // Log.d("---","Res = "+res);
        return res;
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
         Log.d("---","onKey "+i+" | "+KeyEvent.keyCodeToString(i));
        if (i == KeyEvent.KEYCODE_ENTER) {
            //   Log.d("---","ENTER  "+i+" | "+KeyEvent.keyCodeToString(i));
            //btnRes.setFocusable(true);
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            try {
                avLength = Float.parseFloat(etPeople.getText().toString());
                setUncheckedImageButton(ibPeopleBig);
                setUncheckedImageButton(ibPeopleMiddle);
                setUncheckedImageButton(ibPeopleSmall);
            } catch (NumberFormatException e) {
                avLength=164;
            }
        }

        return false;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       // Log.d("---", "onActivtiyuResult");
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onResume() {
        super.onResume();

       // Log.d("---", "onResume");
        if (flag) {
            Log.d("---", "initResultat");
            flag = false;
            initScreenRes();
        } else
            restoreState();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("---", "SaveInstance: " + checks[0]);
        outState.putShortArray("ib", checks);
        outState.putInt("pos", curPositionSpinner);

    }

    private void restoreState() {

        //checks=state.getShortArray("ib");

        for (int i = 0; i < checks.length; i++) {
           // Log.d("---","restore : i="+i+" | "+checks[i]);
            if (checks[i] == 1) {
             //   Log.d("---", "setCheck i=" + i);
                setCheck(i + 1);
            }
        }

    }

    private void setCheck(int pos) {
        switch (pos) {
            case 1:
                Log.d("---", "setCheck 1");
                kStature=10;
                setCheked(ibPeopleBig, null, null);
                break;
            case 2:
                kStature=8;
                setCheked(ibPeopleMiddle, null, null);
                break;
            case 3:
                kStature=6;
                setCheked(ibPeopleSmall, null, null);
                break;
            case 4:
                kNose=115;
                setCheked(ibNoseBig, null, null);
                break;
            case 5:
                kNose=100;
                setCheked(ibNoseMiddle, null, null);
                break;
            case 6:
                kNose=85;
                setCheked(ibNoseSmall, null, null);
                break;
            case 7:
                kFoot=16;
                setCheked(ibFootBig, null, null);
                break;
            case 8:
                kFoot=15;
                setCheked(ibFootMiddle, null, null);
                break;
            case 9:
                kFoot=14;
                setCheked(ibFootSmall, null, null);
                break;
            case 10:
                kHand=115;
                setCheked(ibHandBig, null, null);
                break;
            case 11:
                kHand=100;
                setCheked(ibHandMiddle, null, null);
                break;
            case 12:
                kHand=85;
                setCheked(ibHandSmall, null, null);
                break;
        }
    }

    private void initScreenRes() {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentResultat fResultat = new FragmentResultat();
        // fragmentTransaction.detach(this);
        fragmentTransaction.replace(R.id.fragLayout, fResultat);
        fragmentTransaction.addToBackStack(null);
        //  fragmentTransaction.add(R.id.fragLayout,fResultat);

        //
        fResultat.setResultat(measure());
        // fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    private void showAd() {

        Log.d("---", "Show AD");
        if (mInterstitialAd.isLoaded()) {

            mInterstitialAd.show();
        } else {
            initScreenRes();
            Log.d("---", "The interstitial wasn't loaded yet.");
        }
    }

    @Override
    public void onClick(View view) {

        Log.d("---", "Click" + view);

        etPeople.clearFocus();
        switch (view.getId()) {

            case R.id.btnRes:

             //   measure();
                showAd();
                //initScreenRes();
                break;
            case R.id.ibPeopleBig:
                kStature=10;
                setCheked(ibPeopleBig, ibPeopleMiddle, ibPeopleSmall);
                checks[0] = 1;
                checks[1] = 0;
                checks[2] = 0;
                break;
            case R.id.ibPeopleMiddle:
                kStature=8;
                setCheked(ibPeopleMiddle, ibPeopleBig, ibPeopleSmall);

                checks[0] = 0;
                checks[1] = 1;
                checks[2] = 0;
                break;
            case R.id.ibPeopleSmall:
                kStature=6;
                setCheked(ibPeopleSmall, ibPeopleMiddle, ibPeopleBig);
                checks[0] = 0;
                checks[1] = 0;
                checks[2] = 1;
                break;


            case R.id.ibNoseBig:
                kNose=115;
                setCheked(ibNoseBig, ibNoseMiddle, ibNoseSmall);
                checks[3] = 1;
                checks[4] = 0;
                checks[5] = 0;
                break;
            case R.id.ibNoseMiddle:
                kNose=100;
                setCheked(ibNoseMiddle, ibNoseBig, ibNoseSmall);
                checks[3] = 0;
                checks[4] = 1;
                checks[5] = 0;
                break;
            case R.id.ibNoseSmall:
                kNose=85;
                setCheked(ibNoseSmall, ibNoseMiddle, ibNoseBig);
                checks[3] = 0;
                checks[4] = 0;
                checks[5] = 1;
                break;



            case R.id.ibFootBig:
                kFoot=16;
                setCheked(ibFootBig, ibFootMiddle, ibFootSmall);
                checks[6] = 1;
                checks[7] = 0;
                checks[8] = 0;
                break;
            case R.id.ibFootMiddle:
                kFoot=15;
                setCheked(ibFootMiddle, ibFootBig, ibFootSmall);
                checks[6] = 0;
                checks[7] = 1;
                checks[8] = 0;
                break;
            case R.id.ibFootSmall:
                kFoot=14;
                setCheked(ibFootSmall, ibFootBig, ibFootMiddle);
                checks[6] = 0;
                checks[7] = 0;
                checks[8] = 1;
                break;




            case R.id.ibHandBig:
                kHand=115;
                setCheked(ibHandBig, ibHandMiddle, ibHandSmall);
                checks[9] = 1;
                checks[10] = 0;
                checks[11] = 0;
                break;
            case R.id.ibHandMiddle:
                kHand=100;
                setCheked(ibHandMiddle, ibHandBig, ibHandSmall);
                checks[9] = 0;
                checks[10] = 1;
                checks[11] = 0;
                break;
            case R.id.ibHandSmall:
                kHand=85;
                setCheked(ibHandSmall, ibHandBig, ibHandMiddle);
                checks[9] = 0;
                checks[10] = 0;
                checks[11] = 1;
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

    //For ADMOB
    InterstitialAd mInterstitialAd;

    public class SpinnerAdapter extends ArrayAdapter<String> {
        private Context mContext;
        private String[] list;
        int curPos;

        public SpinnerAdapter(Context c, int textViewResourceId, String[] list, int curPos) {
            super(c, textViewResourceId, list);
            mContext = c;
            this.list = list;
            this.curPos = curPos;
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
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View row = inflater.inflate(R.layout.spin, parent, false);

            TextView label = (TextView) row.findViewById(R.id.tv);
            setText(position, label);
            curPositionSpinner = position;
            return row;
        }

        public void setText(int position, TextView label) {

            String[] ss = list[position].split("[|]");
            //Log.d("---", "[] country = "+ss[0]+"   "  +ss[1]);
            avLength = Float.valueOf(ss[1]);
            // Log.d("---", " country = "+country+"   "  +avLength);
            label.setText(ss[0]);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.screen_conditions, null);
        etPeople = view.findViewById(R.id.etPeople);
        etPeople.setOnKeyListener(this);
        spinner = view.findViewById(R.id.spinner);
        String[] countries = getResources().getStringArray(R.array.countries);



        SpinnerAdapter adapter = new SpinnerAdapter(getActivity(), R.id.tv, countries, curPositionSpinner);
        adapter.setDropDownViewResource(R.layout.spin_dropdown);

        spinner.setAdapter(adapter);

//set Current country
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        curPositionSpinner = preferences.getInt("pos", -1);
        spinner.setSelection(curPositionSpinner);

        ibPeopleBig = view.findViewById(R.id.ibPeopleBig);
        ibPeopleMiddle = view.findViewById(R.id.ibPeopleMiddle);
        ibPeopleSmall = view.findViewById(R.id.ibPeopleSmall);

        ibNoseBig = view.findViewById(R.id.ibNoseBig);
        ibNoseMiddle = view.findViewById(R.id.ibNoseMiddle);
        ibNoseSmall = view.findViewById(R.id.ibNoseSmall);

        ibFootBig = view.findViewById(R.id.ibFootBig);
        ibFootMiddle = view.findViewById(R.id.ibFootMiddle);
        ibFootSmall = view.findViewById(R.id.ibFootSmall);

        ibHandBig = view.findViewById(R.id.ibHandBig);
        ibHandMiddle = view.findViewById(R.id.ibHandMiddle);
        ibHandSmall = view.findViewById(R.id.ibHandSmall);

        btnRes = view.findViewById(R.id.btnRes);
        setClickListener();
        if (savedInstanceState != null) {
            restoreState();
            curPositionSpinner = savedInstanceState.getInt("pos");
            spinner.setSelection(curPositionSpinner);
        }
//AdMob
        MobileAds.initialize(getActivity(),getActivity().getResources().getString(R.string.ad_unit_id_initialize));
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.ad_unit_id_interstitial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                 Log.d("---","Loaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Toast.makeText(getActivity().getBaseContext(),"  Failed AD:"+errorCode,Toast.LENGTH_SHORT).show();
                // Code to be executed when an ad request fails.
                Log.d("---","FailedToLoad :"+errorCode);
            }

            @Override
            public void onAdOpened() {
                //Toast.makeText(getActivity().getBaseContext(),"  Opened AD",Toast.LENGTH_SHORT).show();
                // Code to be executed when the ad is displayed.
                Log.d("---","Opened");
                flag = true;
            }

            @Override
            public void onAdLeftApplication() {
                //  Toast.makeText(getActivity().getBaseContext(),"  LeftApp AD",Toast.LENGTH_SHORT).show();
                // Code to be executed when the user has left the app.
                Log.d("---","AdLeftApplication");
            }

            @Override
            public void onAdClosed() {
               // flag = true;
                Log.d("---","Closed");
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
                // initScreenRes();
                // Toast.makeText(getActivity().getBaseContext(),"  Closed AD",Toast.LENGTH_SHORT).show();
                // Code to be executed when when the interstitial ad is closed.
            }

            @Override
            public void onAdClicked() {
                Log.d("---","AdClickded");
             //   flag = true;
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                Log.d("---","Impression");
                super.onAdImpression();
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        preferences.edit().putInt("pos", curPositionSpinner).commit();
    }

    boolean flag = false;

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
        etPeople.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.d("---","Focus = "+b);
                if(!b)
                {
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });
    }


    private void setCheckedImageButton(ImageButton ib)
    {
        Log.d("---","setChecked "+ib);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            //ibPeopleBig.setBackgroundDrawable(getResources().getDrawable(R.color.colorImageButtonChecked));
            if (ib != null)
                ib.setBackgroundDrawable(getResources().getDrawable(R.drawable.checked));
        } else {
            //ibPeopleBig.setBackground(getResources().getDrawable(R.color.colorImageButtonChecked));
            // ibPeopleBig.setBackground(getResources().getDrawable(R.drawable.checked));
            if (ib != null)
                ib.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.checked));
        }
        ib.setTag(CHECKED);
    }

    private void setUncheckedImageButton(ImageButton ib){
        Log.d("---","setUnChecked "+ib);
        ib.getTag(UNCHECKED);
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            ib.setBackgroundDrawable(getResources().getDrawable(R.drawable.unchecked));
        } else {
            ib.setBackground(getResources().getDrawable(R.drawable.unchecked));
            //  Log.d("---","draw uncheck : "+ibs1);
        }
    }


    private void setCheked(ImageButton ibs, ImageButton ibs1, ImageButton ibs2) {

        setCheckedImageButton(ibs);
        if (ibs1 != null)
            setUncheckedImageButton(ibs1);
        if (ibs2 != null)
            setUncheckedImageButton(ibs2);

    }
}
