package com.example.uploadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Animation extends AppCompatActivity {

    android.view.animation.Animation sunAnim;
    android.view.animation.Animation cloud1Anim;
    android.view.animation.Animation cloud2Anim;
    android.view.animation.Animation titleAnim;
    ImageView sun,cloud1,cloud2;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        sunAnim = AnimationUtils.loadAnimation(this, R.anim.sun);
        cloud1Anim = AnimationUtils.loadAnimation(this, R.anim.cloud1);
        cloud2Anim = AnimationUtils.loadAnimation(this, R.anim.cloud2);
        titleAnim = AnimationUtils.loadAnimation(this, R.anim.title);
        sunAnim = AnimationUtils.loadAnimation(this, R.anim.sun);
        sun = findViewById(R.id.sun1);
        cloud1 = findViewById(R.id.cloud1);
        cloud2 = findViewById(R.id.cloud2);
        title = findViewById(R.id.title1);

        cloud1.startAnimation(cloud2Anim);
        cloud2.startAnimation(cloud1Anim);
        title.startAnimation(titleAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sun.startAnimation(sunAnim);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Animation.this, MainActivity5.class));
                        finish();
                    }
                },2500);

            }
        }, 3500);

    }
}