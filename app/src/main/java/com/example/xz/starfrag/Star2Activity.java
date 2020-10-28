package com.example.xz.starfrag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.xz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Star2Activity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star2);
         ListView lv=findViewById(R.id.list1);
         List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
         Map<String,Object>map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","梅花草");
         map.put("tv_item","清热、消肿、润肺");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","干草");
         map.put("tv_item","清热解毒，祛痰止咳");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","芥菜");
         map.put("tv_item","入药，清热解毒");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","圆叶椒草");
         map.put("tv_item","清新空气，吸毒");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","竹芋");
         map.put("tv_item","清新空气");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","皇冠草");
         map.put("tv_item","观赏，水生养殖");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","鬼针草");
         map.put("tv_item","清热降火，止咳化痰");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","秋葵");
         map.put("tv_item","助消化，护肠胃");
         list.add(map);

         map =new HashMap<String,Object>();
         map.put("iv",R.drawable.star_xingxing);
         map.put("tv_title","铜钱草");
         map.put("tv_item","通风，观赏");
         list.add(map);

         //适配器
         SimpleAdapter adapter=new SimpleAdapter(
                 this,//上下文
                 list,//数据源
                 R.layout.layout_list_item,//布局
                 new String[]{"iv","tv_title","tv_item","item_bt"},//Map中的KEY
                 new int[]{R.id.iv,R.id.tv_title,R.id.tv_item}
                 );
         //关联适配器
         lv.setAdapter(adapter);

      ImageView bc = findViewById(R.id.back);
      bc.setOnClickListener(new View.OnClickListener(){

       @Override
       public void onClick(View v) {
        Star2Activity.this.finish();
       }
      });
    }
}
