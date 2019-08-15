package com.e.taskapps;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.RED;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {




    public BoardFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textTitle = view.findViewById(R.id.textTitle);
        TextView textDesc = view.findViewById(R.id.textDesc);
        Button startBtn= view.findViewById(R.id.buttonStart);
        RelativeLayout relativeLayout= view.findViewById(R.id.back);

        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                textTitle.setText("Добро пожаловать!");
                textDesc.setText("Мир записи!!!");
                relativeLayout.setBackgroundColor(Color.MAGENTA);
                imageView.setImageResource(R.drawable.group);
                break;

            case 1:
                textTitle.setText("Ознакомтесь с приложением");
                textDesc.setText("Пишите заметки");
                relativeLayout.setBackgroundColor(Color.YELLOW);
                imageView.setImageResource(R.drawable.checklist);
                startBtn.setVisibility(View.GONE);
                break;

            case 2:
                textTitle.setText("Делайте записи");
                textDesc.setText("Ваши заметки всегда в нашей памяти!");
                startBtn.setVisibility(View.VISIBLE);
                relativeLayout.setBackgroundColor(Color.GREEN);
                imageView.setImageResource(R.drawable.notestick);
                break;
        }
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
                preferences.edit().putBoolean("isShown", true).apply();
                startActivity(new Intent(getContext(),MainActivity.class));
                getActivity().finish();
            }
        });

        return view;
    }
}
