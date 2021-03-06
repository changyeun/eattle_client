package com.example.choi.eattle;

/**
 * Created by choi on 2015-01-15.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * 뷰페이저를 위한 어댑터 정의
 */
public class ViewPagerAdapter extends PagerAdapter {
    //private String[] names;// 관광지 이름
    //private int[] resIds;// 관광지 사진
    private TourSpot[] tourSpot;
    private Context mContext;//Context 객체

    //생성자
    public ViewPagerAdapter(Context context) {
        mContext = context;
    }
    public ViewPagerAdapter(Context context, TourSpot[] tourSpot){//TourSpot 배열을 전달받았을 때
        this.tourSpot = new TourSpot[tourSpot.length];
        System.arraycopy(tourSpot,0,this.tourSpot,0,tourSpot.length);

        mContext = context;
    }

    public ViewPagerAdapter(Context context, ArrayList<TourSpot> spot) {//TourSpot ArrayList를 받았을 때
        this.tourSpot = spot.toArray(new TourSpot[spot.size()]);
        mContext = context;
    }


    /**
     * 페이지 갯수
     */
    public int getCount() {
        return tourSpot.length;
    }


    /**
     * 뷰페이저가 만들어졌을 때 호출됨(NUMOFSPOT 수만큼 호출됨)
     */
    public Object instantiateItem(ViewGroup container, int position) {
        // create a instance of the page and set data
        SpotPage page = new SpotPage(mContext,position);
        page.setNameText(tourSpot[position].getName());
        page.setImage(tourSpot[position].getResId());

        // 컨테이너에 추가
        //container.addView(page, ((ViewPager)container).getChildCount() > position ? position : ((ViewPager)container).getChildCount());
        container.addView(page, position);

        return page;
    }

    /**
     * Called to remove the page
     */
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }


}
