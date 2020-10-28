package com.example.xz.mefrag;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xz.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().findViewById(R.id.guangbo_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //安卓8.0以上
                Intent intent= new Intent();
                intent.setComponent(new ComponentName(getActivity(), BReseiver.class));
                getActivity().sendBroadcast(intent);

            }
        });
    }

}
