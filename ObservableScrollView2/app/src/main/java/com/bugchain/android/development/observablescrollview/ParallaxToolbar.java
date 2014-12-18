package com.bugchain.android.development.observablescrollview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.nineoldandroids.view.ViewHelper;

public class ParallaxToolbar extends ActionBarActivity implements ObservableScrollViewCallbacks{

    private View mImageView;
   // private View mToolbarView;
    private int  mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax_toolbar);

//        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        mImageView = findViewById(R.id.image);
    //    mToolbarView = findViewById(R.id.toolbar);

        ObservableScrollView scrollView = (ObservableScrollView)findViewById(R.id.scroll);
        scrollView.setScrollViewCallbacks(this);
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

    }

    @Override
    public void onScrollChanged(int scrollY,boolean firstScroll, boolean dargging) {
        int baseColor = getResources().getColor(R.color.primary);
        float alpha = 1 - (float)Math.max(0,mParallaxImageHeight-scrollY)/mParallaxImageHeight;
     //   setBackgroundAlpha(mToolbarView,alpha,baseColor);
        ViewHelper.setTranslationY(mImageView,scrollY/2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }

    private void setBackgroundAlpha(View view,float alpha,int baseColor){
        int a = Math.min(255,Math.max(0,(int)(alpha * 255)))<< 24;
        int rgb = 0x00ffffff & baseColor;
        view.setBackgroundColor(a + rgb);
    }

}
