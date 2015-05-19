package com.codiodes.theummahguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SplashScreenActivity extends FragmentActivity {

    @InjectView(R.id.splash_screen_text) TextView splashScreenText;

    public static final int DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ButterKnife.inject(this);

        //  Text animation.
        YoYo.with(Techniques.Flash)
                .delay(500)
                .duration(1200)
                .playOn(splashScreenText);

        //  Timer to simulate app load.
        simulateWait();
    }

    private void simulateWait() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainScreenActivity.class);
                startActivity(intent);
            }
        }, DELAY); // three seconds wait.
    }
}
