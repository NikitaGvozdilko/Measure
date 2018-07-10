package kodman.isyourpenisbig;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class FragmentConditions extends Fragment implements View.OnClickListener {
    Spinner spinner;

    private void initScreenRes() {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentResultat fResultat= new FragmentResultat();
        fragmentTransaction.add(R.id.fragLayout,fResultat);
        fResultat.setResultat(50.50);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

//        status=RESULTAT;
//        setContentView(R.layout.screen_resultat);
//
//        TextView tvResultat=this.findViewById(R.id.tvResultat);
//        tvResultat.setWidth(tvResultat.getHeight());
       // Log.d("---","Scen REUSLTAT");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnRes:
                initScreenRes();
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

    final short CHECKED = 1;
    final short UNCHECKED = 0;

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
        return view;
    }

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
}
