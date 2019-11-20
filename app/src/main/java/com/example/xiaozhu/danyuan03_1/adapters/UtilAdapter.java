package com.example.xiaozhu.danyuan03_1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xiaozhu on 2019/11/12.
 */

public abstract class UtilAdapter extends RecyclerView.Adapter{

    public OnItemClickLintener onItemClickLintener;
    public OnItemLongClickLintener onItemLongClickLintener;

    public interface OnItemClickLintener{
        void onItemClickLintener(View v, int a);
    }

    public void OnItemClickLintener(OnItemClickLintener lintener) {
        this.onItemClickLintener = lintener;
    }

    public interface OnItemLongClickLintener{
        void onItemLongClickLintener(View v, int a);
    }

    public void OnItemLongClickLintener(OnItemLongClickLintener lintener) {
        this.onItemLongClickLintener = lintener;
    }
}
