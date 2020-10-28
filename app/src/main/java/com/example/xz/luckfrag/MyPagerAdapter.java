package com.example.xz.luckfrag;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
  private List<View> viewList =new ArrayList<View>();

    @NonNull
    @Override//为翻页控件添加视图
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return  viewList.get(position);
    }

    @Override//移除翻页视图中的视图
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView(viewList.get(position));
    }

    @Override//返回view数量
    public int getCount() {
      return viewList.size();
    }

    @Override//判断视图是否返回对象
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
     return view == object;
    }

    public MyPagerAdapter(List<View> viewList) {
        this.viewList = viewList;
    }
}
