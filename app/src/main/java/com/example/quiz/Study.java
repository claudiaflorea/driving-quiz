package com.example.quiz;
import java.io.*;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Study extends Fragment implements View.OnClickListener {

    TextView studyTitle;
    Button btnChapter1, btnChapter2, btnChapter3, btnChapter4, btnChapter5, btnChapter6,
    btnChapter7, btnChapter8, btnChapter9, btnChapter10;
    TextView chapter1;
    View chapter2;
    View chapter3;
    View chapter4;
    View chapter5;
    View chapter6;
    View chapter7;
    View chapter8;
    View chapter9;
    View chapter10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(
                R.layout.study, container, false);
        studyTitle= (TextView) v.findViewById(R.id.studyTitle);
        btnChapter1 = (Button) v.findViewById(R.id.btn_chapter1);
        btnChapter2 = (Button) v.findViewById(R.id.btn_chapter2);
        btnChapter3 = (Button) v.findViewById(R.id.btn_chapter3);
        btnChapter4 = (Button) v.findViewById(R.id.btn_chapter4);
        btnChapter5 = (Button) v.findViewById(R.id.btn_chapter5);
        btnChapter6 = (Button) v.findViewById(R.id.btn_chapter6);
        btnChapter7 = (Button) v.findViewById(R.id.btn_chapter7);
        btnChapter8 = (Button) v.findViewById(R.id.btn_chapter8);
        btnChapter9 = (Button) v.findViewById(R.id.btn_chapter9);
        btnChapter10 = (Button) v.findViewById(R.id.btn_chapter10);
        chapter1= (TextView) v.findViewById(R.id.chapter1_theory);
        chapter1.setVisibility(View.GONE);
        chapter2= (View) v.findViewById(R.id.chapter2_theory);
        chapter2.setVisibility(View.GONE);
        chapter3= (View) v.findViewById(R.id.chapter3_theory);
        chapter3.setVisibility(View.GONE);
        chapter4= (View) v.findViewById(R.id.chapter4_theory);
        chapter4.setVisibility(View.GONE);
        chapter5= (View) v.findViewById(R.id.chapter5_theory);
        chapter5.setVisibility(View.GONE);
        chapter6= (View) v.findViewById(R.id.chapter6_theory);
        chapter6.setVisibility(View.GONE);
        chapter7= (View) v.findViewById(R.id.chapter7_theory);
        chapter7.setVisibility(View.GONE);
        chapter8= (View) v.findViewById(R.id.chapter8_theory);
        chapter8.setVisibility(View.GONE);
        chapter9= (View) v.findViewById(R.id.chapter9_theory);
        chapter9.setVisibility(View.GONE);
        chapter10= (View) v.findViewById(R.id.chapter10_theory);
        chapter10.setVisibility(View.GONE);




        studyTitle.setOnClickListener(this);
        btnChapter1.setOnClickListener(this);
        btnChapter2.setOnClickListener(this);
        btnChapter3.setOnClickListener(this);
        btnChapter4.setOnClickListener(this);
        btnChapter5.setOnClickListener(this);
        btnChapter6.setOnClickListener(this);
        btnChapter7.setOnClickListener(this);
        btnChapter8.setOnClickListener(this);
        btnChapter9.setOnClickListener(this);
        btnChapter10.setOnClickListener(this);
        chapter1.setOnClickListener(this);
        chapter2.setOnClickListener(this);
        chapter3.setOnClickListener(this);
        chapter4.setOnClickListener(this);
        chapter5.setOnClickListener(this);
        chapter6.setOnClickListener(this);
        chapter7.setOnClickListener(this);
        chapter8.setOnClickListener(this);
        chapter9.setOnClickListener(this);
        chapter10.setOnClickListener(this);

        return v;
    }
    @Override
    public void onClick(View v) {
        studyTitle.setVisibility(View.GONE);
        btnChapter1.setVisibility(View.GONE);
        btnChapter2.setVisibility(View.GONE);
        btnChapter3.setVisibility(View.GONE);
        btnChapter4.setVisibility(View.GONE);
        btnChapter5.setVisibility(View.GONE);
        btnChapter6.setVisibility(View.GONE);
        btnChapter7.setVisibility(View.GONE);
        btnChapter8.setVisibility(View.GONE);
        btnChapter9.setVisibility(View.GONE);
        btnChapter10.setVisibility(View.GONE);
        switch (v.getId()) {
            case R.id.btn_chapter1:
                chapter1.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter2:
                chapter2.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter3:
                chapter3.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter4:
                chapter4.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter5:
                chapter5.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter6:
                chapter6.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter7:
                chapter7.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter8:
                chapter8.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter9:
                chapter9.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_chapter10:
                chapter10.setVisibility(View.VISIBLE);
                break;
        }
    }


}
