package kodman.isyourpenisbig;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
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

    //short status=this.START;

    ImageView ivStart;
    ConstraintLayout clStart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("---", "onCreate");
        setContentView(R.layout.activity_main);

        //Add AD
        MobileAds.initialize(this,getResources().getString(R.string.ad_unit_id));
        com.google.android.gms.ads.AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Initialized views
        ivStart = this.findViewById(R.id.imageView);
        ivStart.setOnClickListener(this);
        clStart=this.findViewById(R.id.clStart);


    }


    @Override
    public void onBackPressed() {

        Log.d("---","onBackPress");
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

       // status = CONDITIONS;
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
