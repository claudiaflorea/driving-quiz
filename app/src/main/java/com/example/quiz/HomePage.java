package com.example.quiz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomePage extends Fragment implements View.OnClickListener {

    Button btnStudy, btnPractice;
    ImageView home_img;
    TextView home_txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(
                R.layout.home_page, container, false);

        btnStudy = (Button) v.findViewById(R.id.goToStudy);
        btnPractice = (Button) v.findViewById(R.id.goToPractice);
        home_img= (ImageView) v.findViewById(R.id.home_img);
        home_txt= (TextView) v.findViewById(R.id.home_txt);

        btnStudy.setOnClickListener(this);
        btnPractice.setOnClickListener(this);
        home_img.setOnClickListener(this);
        home_txt.setOnClickListener(this);

        return v;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goToStudy:

        Study study = new Study();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.home_page_view, study);
        ft.addToBackStack(null);
        ft.commit();
        btnStudy.setVisibility(View.GONE);
        btnPractice.setVisibility(View.GONE);
        home_txt.setVisibility(View.GONE);
        home_img.setVisibility(View.GONE);

        break;
            case R.id.goToPractice:

        Practice practice = new Practice();
        FragmentManager fmg = getActivity().getSupportFragmentManager();
        FragmentTransaction ftr = fmg.beginTransaction();
        ftr.replace(R.id.home_page_view, practice);
        ftr.addToBackStack(null);
        ftr.commit();
        btnStudy.setVisibility(View.GONE);
        btnPractice.setVisibility(View.GONE);
        home_txt.setVisibility(View.GONE);
        home_img.setVisibility(View.GONE);
        }
}


}
