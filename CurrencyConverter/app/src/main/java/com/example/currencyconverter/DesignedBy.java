package com.example.currencyconverter;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class DesignedBy extends AppCompatActivity {

    MediaPlayer money;
    private SectionsStatePagerAdapter mSectionStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designed_by);

        mSectionStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        money = MediaPlayer.create(DesignedBy.this, R.raw.money);
        money.start();

    }

    private void setupViewPager(ViewPager mViewPager){

        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment(), "EuroFragment");
        adapter.addFragment(new Fragment(), "PoundsFragment");
        adapter.addFragment(new Fragment(), "YenFragment");
        mViewPager.setAdapter(adapter);

    }

    public void onBackPressed(){

        MainActivity.currencyImage.setEnabled(true);
        money.stop();
        this.finish();

    }

    public void nextClick(View view){

        if(mViewPager.getCurrentItem() == 0) {
            mViewPager.setCurrentItem(1);
        }
        if(mViewPager.getCurrentItem() == 1){
            mViewPager.setCurrentItem(2);
        }
        if(mViewPager.getCurrentItem() == 2){
            mViewPager.setCurrentItem(0);
        }
    }

    public void previousClick(View view){

        if(mViewPager.getCurrentItem() == 0) {
            mViewPager.setCurrentItem(2);
        }
        if(mViewPager.getCurrentItem() == 1){
            mViewPager.setCurrentItem(0);
        }
        if(mViewPager.getCurrentItem() == 2){
            mViewPager.setCurrentItem(1);
        }

    }



}
