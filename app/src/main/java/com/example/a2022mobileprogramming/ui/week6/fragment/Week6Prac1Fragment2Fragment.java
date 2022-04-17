package com.example.a2022mobileprogramming.ui.week6.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a2022mobileprogramming.R;

public class Week6Prac1Fragment2Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_week6_prac1_fragment2, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button getTextBtn = getActivity().findViewById(R.id.week6_prac1_fragment2_button);
        getTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView fragment1Tv = getActivity().findViewById(R.id.week6_prac1_fragment1_textview);
                Toast.makeText(getActivity(), fragment1Tv.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
