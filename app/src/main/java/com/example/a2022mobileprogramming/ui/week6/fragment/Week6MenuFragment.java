package com.example.a2022mobileprogramming.ui.week6.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a2022mobileprogramming.R;
import com.example.a2022mobileprogramming.ui.week6.Week6Activity;

public class Week6MenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_week6_menu, container, false);

        Button button = (Button) rootView.findViewById(R.id.week6_menu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Week6Activity activity = (Week6Activity) getActivity();
                activity.onFragmentChanged(1);
            }
        });

        return rootView;
    }
}
