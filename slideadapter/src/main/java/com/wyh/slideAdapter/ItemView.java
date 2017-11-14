package com.wyh.slideAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xmwj.slideadapter.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.List;


/**
 * created by yhao on 2017/9/8.
 */


public class ItemView extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;
    private View mContent;
    private View mLeftView;
    private View mRightView;


    ItemView(View itemView, View content, View leftMenu, View rightMenu) {
        super(itemView);
        mItemView = itemView;
        mContent = content;
        mLeftView = leftMenu;
        mRightView = rightMenu;
        mViews = new SparseArray<>();
    }

    static ItemView create(@NonNull Context context, @NonNull ViewGroup parent, @NonNull NormalItem normalItem) {
        return create(context, parent, new SlideItem(normalItem.layoutId, 0, 0, 0, 0));
    }

    static ItemView create(@NonNull Context context, @NonNull ViewGroup parent, @NonNull final SlideItem slideItem) {
        final View itemView = LayoutInflater.from(context).inflate(R.layout.yhaolpz_slide_layout, parent, false);
        LinearLayout linearLayout = itemView.findViewById(R.id.yhaolpz_linearLayout);
        final View content;
        View leftMenu = null;
        View rightMenu = null;
        if (slideItem.leftMenuLayoutId != 0) {
            leftMenu = LayoutInflater.from(context).inflate(slideItem.leftMenuLayoutId, linearLayout, false);
            linearLayout.addView(leftMenu);
        }
        content = LayoutInflater.from(context).inflate(slideItem.itemLayoutId, linearLayout, false);
        linearLayout.addView(content);
        if (slideItem.rightMenuLayoutId != 0) {
            rightMenu = LayoutInflater.from(context).inflate(slideItem.rightMenuLayoutId, linearLayout, false);
            linearLayout.addView(rightMenu);
        }
        return new ItemView(itemView, content, leftMenu, rightMenu);
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    View getContentView() {
        return mContent;
    }

    View getLeftMenu() {
        return mLeftView;
    }

    View getRightMenu() {
        return mRightView;
    }


    public ItemView setText(int viewId, String text) {
        TextView textView = getView(viewId);
        if (textView != null) {
            textView.setText(text);
        }
        return this;
    }

    public ItemView setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        if (view != null) {
            view.setImageResource(resId);
        }
        return this;
    }

    public ItemView setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnClickListener(listener);
        }
        return this;
    }

    public ItemView setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        if (view != null) {
            view.setOnLongClickListener(listener);
        }
        return this;
    }

    public ItemView setOnClickListener(final View.OnClickListener listener) {
        ((SlideLayout) getView(R.id.yhaolpz_slideLayout)).setCustomOnClickListener(
                new SlideLayout.CustomOnClickListener() {
                    @Override
                    public void onClick() {
                        listener.onClick(mItemView);
                    }
                });
        return this;
    }

    public ItemView closeMenu() {
        ((SlideLayout) getView(R.id.yhaolpz_slideLayout)).getAdapter().closeOpenItem();
        return this;
    }
    public ItemView setBanner(int viewId, List<String> images,List<String> titles) {
        Banner banner = getView(viewId);
        if (banner != null) {
            //设置banner样式
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(images);
            //设置banner动画效果
            banner.setBannerAnimation(Transformer.DepthPage);
            //设置标题集合（当banner样式有显示title时）
            banner.setBannerTitles(titles);
            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            //设置轮播时间
            banner.setDelayTime(1500);
            //设置指示器位置（当banner模式中有指示器时）
            banner.setIndicatorGravity(BannerConfig.CENTER);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }
        return this;
    }
}
