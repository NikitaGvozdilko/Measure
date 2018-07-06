package kodman.isyourpenisbig;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return 20;
        }

        public Object getItem(int position) {
            return R.drawable.people_icon;
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(MainActivity.this);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(R.drawable.people_icon);
            return imageView;
        }

        // references to our images
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.screen_conditions);
Spinner spinner=this.findViewById(R.id.spinner);
        String[] countries= getResources().getStringArray(R.array.countries);
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spin, R.id.tvCategory,countries);
        adapter.setDropDownViewResource(R.layout.spin_dropdown);


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
