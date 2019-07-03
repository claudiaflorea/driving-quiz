package com.example.quiz;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClarifyDoubt extends AppCompatActivity {
    TextView txtMessage;
    Button btnTryAgain;
    BottomNavigationView navigation;
    FragmentManager fm;
    FragmentTransaction ft;
    Practice practiceFrg;
    HomePage homePageFrg;
    Study studyFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clarify_doubt);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Bundle bundleFromMainActivity = getIntent().getExtras();
        int finalScore = bundleFromMainActivity.getInt(MainActivity.SCOREKEY);


        btnTryAgain=(Button) findViewById(R.id.tryAgain);
        btnTryAgain.setVisibility(View.VISIBLE);
        txtMessage = (TextView)findViewById(R.id.tvMessage);
        txtMessage.setVisibility(View.VISIBLE);
        txtMessage.setText("Your score is "+ finalScore+ " out of 25!");
        this.setFinishOnTouchOutside(false);
    }


    public void tryAgain(View v){
        Practice practice = new Practice();
        FragmentManager fmg = getSupportFragmentManager();
        FragmentTransaction ftr = fmg.beginTransaction();
        ftr.replace(R.id.clarify_doubt, practice);
        ftr.addToBackStack(null);
        ftr.commit();
        txtMessage.setVisibility(View.GONE);
        btnTryAgain.setVisibility(View.GONE);
        navigation.setVisibility(View.GONE);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm = getSupportFragmentManager();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.content, new HomePage());
                    ft.commit();
                    btnTryAgain.setVisibility(View.GONE);
                    txtMessage.setVisibility(View.GONE);
                    return true;

                case R.id.navigation_dashboard:
                    fm = getSupportFragmentManager();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.content, new Practice());
                    ft.commit();
                    btnTryAgain.setVisibility(View.GONE);
                    txtMessage.setVisibility(View.GONE);
                    return true;

                case R.id.navigation_notifications:
                    fm = getSupportFragmentManager();
                    ft = fm.beginTransaction();
                    ft.replace(R.id.content, new Study());
                    ft.commit();
                    btnTryAgain.setVisibility(View.GONE);
                    txtMessage.setVisibility(View.GONE);
                    return true;
            }
            return false;
        }
    };

}

