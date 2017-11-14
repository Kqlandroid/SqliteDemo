package com.demos.tags.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demos.tags.R;
import com.demos.tags.bean.BannerBean;
import com.demos.tags.bean.NewsBean;
import com.itheima.loopviewpager.LoopViewPager;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.L;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.listener.ItemClickSupport;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class OsChinaActivity extends AppCompatActivity {
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    @BindView(R.id.recycler_view)
    ItheimaRecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerViewHeader header;
    LoopViewPager loopViewPager;
    private  int state = 0;
    private static final int STATE_REFRESH = 1;
    private static final int STATE_MORE = 2;
    private  String nextPagerToken;
    private NewsBean bean;
    private List<String> imgList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private List<NewsBean.ResultBean.ItemsBean> itemBeanDatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_china);
        ButterKnife.bind(this);
        header = (RecyclerViewHeader) findViewById(R.id.recycler_header);
        header.attachTo(recyclerView);
        loopViewPager = (LoopViewPager) findViewById(R.id.lvp_pager);
        initData();
        initBanner();


    }

    private void initBanner() {
        Request request = ItheimaHttp.newGetRequest("action/apiv2/banner?catalog=1");//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<BannerBean>() {

            @Override
            public void onResponse(BannerBean bannerBean, Headers headers) {
                List<BannerBean.ResultBean.ItemsBean> itemsBean =bannerBean.getItemDatas();
                for (int i = 0; i < itemsBean.size(); i++) {
                    imgList.add(itemsBean.get(i).getImg());
                    titleList.add(itemsBean.get(i).getName());
                    loopViewPager.setImgData(imgList);
                    loopViewPager.setTitleData(titleList);
                    loopViewPager.start();
                }
            }

            /**
             * 可以不重写失败回调
             * @param call
             * @param e
             */
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
            }
        });

    }

    private void initData() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>(swipeRefreshLayout, recyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_recylerview;
            }

            @Override
            public String getApi() {
                String url="action/apiv2/news?pageToken=";
                switch (state){
                    case STATE_REFRESH:
                        break;
                    case STATE_MORE:
                        nextPagerToken = bean.getResult().getNextPageToken();
                        url+=nextPagerToken;
                        break;
                }
                //接口
                return url;
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                System.out.println("isMoreData" + holder);
                state = STATE_MORE;
                return true;
            }
        };
        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<NewsBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                L.i("setLoadingDataListener onRefresh");
                state = STATE_REFRESH;
            }

            @Override
            public void onSuccess(NewsBean o ,Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                L.i("setLoadingDataListener onSuccess: " + o);
                bean=o;
                List<NewsBean.ResultBean.ItemsBean> itemBeanList = o.getItemDatas();
                itemBeanDatas.addAll(itemBeanList);
            }
        });
        ItemClickSupport itemClickSupport = new ItemClickSupport(recyclerView);
        //点击事件
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                int id =  itemBeanDatas.get(position).getId();
                Intent intent = new Intent(OsChinaActivity.this,DeatilActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        //开始请求
        pullToLoadMoreRecyclerView.requestData();

    }
    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<NewsBean.ResultBean.ItemsBean> {
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
            tvpubDate.setText(mData.getPubDate());
            tvCommentCount.setText(mData.getCommentCount()+"");

        }


        /**
         * 给按钮添加点击事件（button改成你要添加点击事件的id）
         * @param v
         */

    }
}
