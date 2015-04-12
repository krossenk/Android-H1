package com.krk.h1201271039;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{

    ImageButton mStartBtn;
    View mBgView;
    TextView mText;
    TextView mBlinkText;
    MediaPlayer mMediaPlayer;
    Animation mAnimBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = MediaPlayer.create(this, R.raw.bubble_sound);
        mText = (TextView) findViewById(R.id.txt_bubble);
        mBgView = findViewById(R.id.bg_view);
        mBlinkText = (TextView) findViewById(R.id.txt_blink);
        mStartBtn = (ImageButton) findViewById(R.id.btn_start);
        mAnimBlink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);

        mBgView.setOnClickListener(this);
        mStartBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        if(view.getId() == R.id.btn_start) {
            mMediaPlayer.start();
            mText.setText(getString(R.string.well_done));
            mStartBtn.setVisibility(View.GONE);
            mBlinkText.startAnimation(mAnimBlink);
            mBlinkText.setVisibility(View.VISIBLE);
        } else if(view.getId() == R.id.bg_view && mStartBtn.getVisibility() == View.GONE) {
            mText.setText(getString(R.string.blow_bubble));
            mStartBtn.setVisibility(View.VISIBLE);
            mBlinkText.clearAnimation();
            mBlinkText.setVisibility(View.GONE);
        }
    }
}
