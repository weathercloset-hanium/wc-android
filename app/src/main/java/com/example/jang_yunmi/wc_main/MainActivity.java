package com.example.jang_yunmi.wc_main;

import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    private ImageSwitcher sw;
    private Button pr,nx;
    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {R.drawable.bot, R.drawable.greendress};
    int count = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw  = (ImageSwitcher) findViewById(R.id.sw);
        pr = (Button) findViewById(R.id.pr);
        nx = (Button) findViewById(R.id.nx);
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imgeView = new ImageView(getApplicationContext());
                imgeView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imgeView;
            }
        });

        nx.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;
                sw.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
            }
        });

        pr.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex--;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;
                else if (currentIndex < 0)
                    currentIndex = imageIds.length-1;
                sw.setImageResource(imageIds[currentIndex]); // set the image in ImageSwitcher
            }
        });

    }
}




