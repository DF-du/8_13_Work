package com.csj.zjtk_7;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mStart;
    private Button mPause;
    private Button mPlaying;
    private Button mStop;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        initView();
    }

    private void initView() {
        mStart = (Button) findViewById(R.id.start);
        mStart.setOnClickListener(this);
        mPause = (Button) findViewById(R.id.pause);
        mPause.setOnClickListener(this);
        mPlaying = (Button) findViewById(R.id.playing);
        mPlaying.setOnClickListener(this);
        mStop = (Button) findViewById(R.id.stop);
        mStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                // TODO 20/08/13
                mediaPlayer = MediaPlayer.create(this, R.raw.aaa);
                mediaPlayer.start();
                break;
            case R.id.pause:
                mediaPlayer.pause();
                break;
            case R.id.playing:
                if (!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
                break;
            case R.id.stop:
                mediaPlayer.stop();
                break;
            default:
                break;
        }
    }
}
