package com.demos.tags;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.demos.tags.bean.BlogBean;
import com.demos.tags.utile.utils.StringUtils;

import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    ItheimaRecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    RecyclerViewHeader header;
    @BindView(R.id.rg_blog_head_layout)
    RadioGroup rg_blog_head_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        ButterKnife.bind(this);
        header = (RecyclerViewHeader) findViewById(R.id.recycler_header);
        header.attachTo(mRecyclerView);
        initDatta();
        rg_blog_head_layout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.bt_blog_head_recommend:
                        url="action/apiv2/blog?catalog=3&pageToken=";
                        break;
                    case R.id.bt_blog_head_hot:
                        url="action/apiv2/blog?catalog=2&nextPageToken=";
                        break;
                    case R.id.bt_blog_new_blog:
                        url="action/apiv2/blog?catalog=1&nextPageToken=";
                        break;
                }
                initDatta();
            }
        });
    }
    String url = "action/apiv2/blog?catalog=2&20pageToken=";
    private void initDatta() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<BlogBean>(mSwipeRefreshLayout, mRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_recylerview;
            }

            @Override
            public String getApi() {
                //接口
                return url;
            }
            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
//            @Override
//            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
//                System.out.println("isMoreData" + holder);
//
//                return true;
//            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();

    }
    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<BlogBean.ResultBean.ItemsBean> {
        //换成你布局文件中的id
        @BindView(R.id.tv_1)
        TextView tvTitle;
        @BindView(R.id.tv_12)
        TextView tvbody;
        @BindView(R.id.tv_123)
        TextView tvpubDate;
        @BindView(R.id.tv_1234)
        TextView tvCommentCount;

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            tvTitle.setText(mData.getTitle());
            tvbody.setText(mData.getBody());
            tvpubDate.setText(mData.getAuthor()+" "+ StringUtils.friendly_time(mData.getPubDate()));
            tvCommentCount.setText(mData.getCommentCount()+"");
        }


        /**
         * 给按钮添加点击事件（button改成你要添加点击事件的id）
         * @param v
         */
//        @OnClick(R.id.button)
//        public void click(View v) {
//        }
    }
}
