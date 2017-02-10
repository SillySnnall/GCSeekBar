package com.stringbox.gcseekbar;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

/**
 * 内容：GC
 * 作者：StringBOX
 * 时间：2017/2/10 15:07
 */

public class GCSeekBar extends SeekBar {

    private boolean mIsSlide = true;

    public GCSeekBar(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public GCSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.seekBarStyle);
    }

    public GCSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        //原来是要将TouchEvent传递下去的,我们不让它传递下去就行了
        if(mIsSlide) {
            return super.onTouchEvent(event);
        }else {
            return false ;
        }
    }

    /**
     * 设置GCSeekBar是否可以滑动
     * @param isSlide
     */
    public void setIsSlide(boolean isSlide){
        mIsSlide = isSlide;

    }

    /**
     * 设置GCSeekBar是否有滑动圆块
     * @param isThumb
     */
    public void setIsThumb(boolean isThumb){
        if(!isThumb) {
            setThumb(new BitmapDrawable());
        }
    }
}
