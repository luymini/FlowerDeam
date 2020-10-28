package com.example.xz;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import com.example.xz.luckfrag.LuckFragment;
import com.example.xz.mefrag.MeFragment;
import com.example.xz.partnerfrag.PartnerFragment;
import com.example.xz.starfrag.StarFragment;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
   RadioGroup mainRg;
   ImageView xingxing;
    //声明四个按钮对应的Fragment对象
    FragmentManager manager;
    Fragment starFrag, luckFrag, partnerFrag, meFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent =new Intent(MainActivity.this,MusicService.class);
        xingxing =findViewById(R.id.mxingxing);
        xingxing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(MusicService.isplay==false){
                    startService(intent);
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play_xingxing,null));
                }else{
                    stopService(intent);
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play_xingxing,null));
                }
            }
        });


        mainRg = findViewById(R.id.main_rg);
        mainRg.setOnCheckedChangeListener(this);
        // 创建碎片对象
       starFrag= new StarFragment();
       luckFrag = new LuckFragment();
       partnerFrag = new PartnerFragment();
       meFrag =new MeFragment();
       addFragmentPage();
    }
    @Override
    protected void onStart() {
        startService(new Intent(MainActivity.this,MusicService.class));//启动Service
        super.onStart();
    }

    private void addFragmentPage() {
        manager = getSupportFragmentManager();
         FragmentTransaction  transaction =manager.beginTransaction();
        //将四个fragment统一加到布局中
        transaction.add(R.id.main_layout_center, starFrag);
        transaction.add(R.id.main_layout_center, partnerFrag);
        transaction.add(R.id.main_layout_center, luckFrag);
        transaction.add(R.id.main_layout_center, meFrag);
        //隐藏后面的三个
        transaction.hide(partnerFrag);
        transaction.hide(luckFrag);
        transaction.hide(meFrag);
        //提交碎片改变后的事务
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
    FragmentTransaction transaction =  manager.beginTransaction();
        switch (i){
            case R.id.main_rb_star:
                transaction.hide(partnerFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(starFrag);

                break;
            case R.id.main_rb_partner:
                transaction.hide(starFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(partnerFrag);

                break;
            case R.id.main_rb_luck:
                transaction.hide(starFrag);
                transaction.hide(partnerFrag);
                transaction.hide(meFrag);
                transaction.show(luckFrag);

                break;
            case R.id.main_rb_me:
                transaction.hide(starFrag);
                transaction.hide(luckFrag);
                transaction.hide(partnerFrag);
                transaction.show(meFrag);

                break;
        }
        transaction.commit();
    }


}