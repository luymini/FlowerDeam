package com.example.xz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    @Override
    public String toString() {
        return "MusicService{}";
    }

    static boolean isplay;//记录播放状态
    MediaPlayer player;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
@Override
  public void onCreate(){
        //创建MediaPlayer
    player =MediaPlayer.create(this,R.raw.music);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!player.isPlaying()){
            player.start();
            isplay=player.isPlaying();//设置当前音乐为正在播放
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();//当前音乐停止
        isplay=player.isPlaying();
        player.release();//释放资源
        super.onDestroy();
    }
}
