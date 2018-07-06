package kodman.isyourpenisbig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv=this.findViewById(R.id.imageView);
        TextView tv=this.findViewById(R.id.tvTitle2);
        View vLine=this.findViewById(R.id.vLine);

        Log.d("---","onCreate tv Width ="+tv.getLayoutParams().width);

       //ViewGroup.LayoutParams params = vLine.getLayoutParams();
      // params.width = tv.getWidth();
       // vLine.setLayoutParams(params);
        //vLine.setWidth(100);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("---","click");
            }
        });

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");

        com.google.android.gms.ads.AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
