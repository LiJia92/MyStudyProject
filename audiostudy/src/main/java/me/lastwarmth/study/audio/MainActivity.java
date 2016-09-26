package me.lastwarmth.study.audio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mRecordBtn;
    private Button mPlayBtn;

    private AudioCapture capture;
    private AudioPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecordBtn = (Button) findViewById(R.id.btn_record);
        mPlayBtn = (Button) findViewById(R.id.btn_play);


        capture = new AudioCapture();
        player = new AudioPlayer();
        player.startPlayer();


        mRecordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capture.setOnAudioFrameCapturedListener(new AudioCapture.OnAudioFrameCapturedListener() {
                    @Override
                    public void onAudioFrameCaptured(byte[] audioData) {
                        player.play(audioData, 0, audioData.length);
                    }
                });
                capture.startCapture();
            }
        });

        mPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capture.stopCapture();
                player.stopPlayer();
            }
        });
    }
}
