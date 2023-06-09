package com.ui.ApkSteady.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spacing;//间距padding

    public LinearSpacingItemDecoration(Context context, int spacings) {
        //获取需要设置的间距值dp，这里不写死，调用时传过来
//        spacing = context.getResources().getDimensionPixelSize(R.dimen.d10);
        spacing = spacings;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
//        outRect.top = spacing;//item上边的间距
//        outRect.left = spacing;//左边间距
//        outRect.right = spacing;//右边间距
        outRect.bottom = spacing;//设置bottom padding
    }
}