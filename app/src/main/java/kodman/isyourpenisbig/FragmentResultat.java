package kodman.isyourpenisbig;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

public class FragmentResultat extends Fragment {

    public void setResultat(Float resultat)
    {
        this.resultat=resultat;
    }
    double resultat=123;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.screen_resultat, null);
        MobileAds.initialize(getActivity(),getResources().getString(R.string.ad_unit_id_initialize));

        com.google.android.gms.ads.AdView mAdView = view.findViewById(R.id.adView);

     //   Log.d("---","mAdView width = "+mAdView.getWidth());
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//        mAdView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
//            @Override
//            public void onViewAttachedToWindow(View view) {
//                Log.d("---","onAttach view="+view);
//            }
//
//            @Override
//            public void onViewDetachedFromWindow(View view) {
//                Log.d("---","onDeAttach view="+view);
//            }
//        });


        TextView tvResultat= view.findViewById(R.id.tvResultat);
        tvResultat.setText(new DecimalFormat("#0.00").format(resultat));
Button btnRestart= view.findViewById(R.id.btnRestart);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}
