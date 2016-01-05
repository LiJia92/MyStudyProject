package com.example.miali.mediaplayerstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Button btnPause, btnPlayUrl, btnStop;
    private SeekBar skbProgress;
    private Player player;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.setTitle("在线音乐播放---hellogv编写");
//
//        btnPlayUrl = (Button) this.findViewById(R.id.btnPlayUrl);
//        btnPlayUrl.setOnClickListener(new ClickEvent());
//
//        btnPause = (Button) this.findViewById(R.id.btnPause);
//        btnPause.setOnClickListener(new ClickEvent());
//
//        btnStop = (Button) this.findViewById(R.id.btnStop);
//        btnStop.setOnClickListener(new ClickEvent());
//
//        skbProgress = (SeekBar) this.findViewById(R.id.skbProgress);
//        skbProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
//        player = new Player(skbProgress);

    }

    class ClickEvent implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            if (arg0 == btnPause) {
                player.pause();
            } else if (arg0 == btnPlayUrl) {
                //在百度MP3里随便搜索到的,大家可以试试别的链接
                String url = "http://10.0.0.36:8080/MiaMusic/blandness.mp3";
                player.playUrl(0);
            } else if (arg0 == btnStop) {
                player.stop();
            }
        }
    }

    class SeekBarChangeEvent implements SeekBar.OnSeekBarChangeListener {
        int progress;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            // 原本是(progress/seekBar.getMax())*player.mediaPlayer.getDuration()
            this.progress = progress * player.mediaPlayer.getDuration()
                    / seekBar.getMax();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // seekTo()的参数是相对与影片时间的数字，而不是与seekBar.getMax()相对的数字
            player.mediaPlayer.seekTo(progress);
        }
    }

}
