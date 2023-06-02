package com.ui.ApkSteady.ui.view;

import android.content.Context;
import android.util.AttributeSet;

public class AutoSizeImageView extends androidx.appcompat.widget.AppCompatImageView {

    public AutoSizeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        try {

            getLayoutParams().height = getMeasuredWidth();

        } catch (Exception e) {
            // TODO: handle exception

        }

    }

}
