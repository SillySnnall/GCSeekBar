package com.stringbox.gcseekbartest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.stringbox.gcseekbar.GCSeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MediaPlayer mPlayer;
    private GCSeekBar mGcseekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGcseekbar = (GCSeekBar) findViewById(R.id.gcseekbar);
        mGcseekbar.setIsSlide(false);
        mGcseekbar.setIsThumb(false);
        mGcseekbar.setProgressDrawable(getResources().getDrawable(R.drawable.seekbar_bg));
        test();
    }

    private void test() {
        mPlayer = MediaPlayer.create(this, R.raw.buddha_bg);
        mGcseekbar.setMax(mPlayer.getDuration());//设置进度条
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int currentPosition = mPlayer.getCurrentPosition();
                Log.e(TAG, "testrun: " + currentPosition);
                mGcseekbar.setProgress(currentPosition);
            }
        }, 0, 500);
        mPlayer.start();
    }
}
