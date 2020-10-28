package com.example.xz.mefrag;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BReseiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"正在下载新版本...",Toast.LENGTH_SHORT).show();
    }
}