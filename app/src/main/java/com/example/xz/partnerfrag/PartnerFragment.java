package com.example.xz.partnerfrag;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xz.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class PartnerFragment extends Fragment {
private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_partner, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         final EditText editText = getActivity().findViewById(R.id.ed_partner);
         Button save = getActivity().findViewById(R.id.bt_save);
         final TextView showtext =getActivity().findViewById(R.id.tv_show);
         final CheckBox ck=getActivity().findViewById(R.id.ck);
         sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);//本应用进行读写
         editor = sharedPreferences.edit();
         save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                    editor.putString("name",editText.getText().toString());
                    editor.apply();//异步
                 if(ck.isChecked()){
                     showtext.setText(sharedPreferences.getString("name",""));
                 }
            }
         });
        showtext.setText(sharedPreferences.getString("name",""));
    }

}