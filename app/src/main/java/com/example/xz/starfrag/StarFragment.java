package com.example.xz.starfrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.xz.R;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class StarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView iv1 = getActivity().findViewById(R.id.shuiping);
        iv1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            startActivity(new Intent(getActivity(), Star2Activity.class));;
            }
        });
    }

}
