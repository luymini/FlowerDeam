package com.example.xz.luckfrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.xz.R;

import java.util.ArrayList;
import java.util.List;

public class luck2Activity extends AppCompatActivity {

    private ViewPager viewpager;
    private ArrayList arrayList;
    private View view1,view2,view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck2);
        viewpager = findViewById(R.id.viewpager);
        ImageView back= findViewById(R.id.back_luck);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        LayoutInflater layoutInflater = getLayoutInflater();//动态生成布局
        view1=layoutInflater.inflate(R.layout.layout_viewpager1,null);//基于布局生成3个视图
        view2=layoutInflater.inflate(R.layout.layout_viewpager2,null);
        view3=layoutInflater.inflate(R.layout.layout_viewpager3,null);
        List<View> viewList =new ArrayList<View>();//创建视图列表并添加三个视图
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(viewList);//构造基于listview得翻页适配器实例
        viewpager.setAdapter(myPagerAdapter);//最后将适配器设为该实例
    }
}