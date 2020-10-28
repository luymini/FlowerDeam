package com.example.xz.huanying;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.xz.MainActivity;
import com.example.xz.R;

public class WelcomActivity extends AppCompatActivity {
TextView tv;
int count =5;

Handler handler = new Handler(){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
       if(msg.what==1){
           count--;
           if(count== 0){
               Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
               startActivity(intent);
               finish();
           }else{
               tv.setText(String.valueOf(count));
               handler.sendEmptyMessageDelayed(1,500);//不为0继续发送消息
           }
       }
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        tv = findViewById(R.id.welcome_tv);

        handler.sendEmptyMessageDelayed(1,500);//0.5秒
    }
}