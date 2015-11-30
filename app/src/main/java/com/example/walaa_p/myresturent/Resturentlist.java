package com.example.walaa_p.myresturent;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by walaa-p on 09/30/2015.
 */
public class Resturentlist extends AppCompatActivity {
    ProgressDialog PD;
    public static DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    LinearLayout mainContentLayout;
    public static  android.support.v7.widget.Toolbar t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PD=new ProgressDialog(this);
        PD.setMessage("HELLO");
        PD.setCancelable(false);

        setContentView(R.layout.resturentlist);
        SlidingTabFragment stf =new SlidingTabFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout, stf, "stf").commit();

        mainContentLayout = (LinearLayout) this.findViewById(R.id.maincontent_frag);
        t=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        this.setSupportActionBar(t);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,t,R.string.opendrawer,R.string.closedrawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainContentLayout.setTranslationX(drawerView.getWidth()*slideOffset);
                drawerLayout.bringChildToFront(drawerView);
                mainContentLayout.requestLayout();
            }
        };

        drawerLayout.setDrawerListener(toggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                toggle.syncState();
            }
        });
    }





}
