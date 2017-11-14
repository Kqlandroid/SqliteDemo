package com.demos.tags.slideAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.demos.tags.R;
import com.demos.tags.slideAdapter.bean.Bean;
import com.wyh.slideAdapter.BottomListener;
import com.wyh.slideAdapter.FooterBind;
import com.wyh.slideAdapter.HeaderBind;
import com.wyh.slideAdapter.ItemBind;
import com.wyh.slideAdapter.ItemView;
import com.wyh.slideAdapter.SlideAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlideAdapterActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_adapter);
        recyclerview= (RecyclerView) findViewById(R.id.recyclerview);
        initData();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main,menu);
//        return true;
//    }

    private void initData() {
        final List<Bean> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add(new Bean("第" + i + "个标题"));
        }
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        SlideAdapter.load(data)
                .item(R.layout.slideadapter_recyclerview_layout_item,
                        R.layout.left_menu, 1f, R.layout.right_menu, 0.4f)
                .padding(5)
                .header(R.layout.header_top_layout, 0.3f)
                .bind(new HeaderBind() {
                    @Override
                    public void onBind(ItemView itemView, int i) {
                        itemView.setText(R.id.tv_header, "TOP");
                        List<String> list = new ArrayList<>();
                        List<String> title = new ArrayList<>();
                        for (int j = 0; j < 5; j++) {
                            list.add("http://www.86ps.com/imgWeb/psd/hf_fj/FJ_159.jpg");
                            title.add("广告" + i);
                        }
                        itemView.setBanner(R.id.banner, list, title);
                    }
                })
                .footer(R.layout.footer_bootem_layout, 0.1f)
                .bind(new FooterBind() {
                    @Override
                    public void onBind(ItemView itemView, int i) {
                        itemView.setText(R.id.tv_footer, "BOOTEM");
                    }
                }).listen(new BottomListener() {
            @Override
            public void onBottom(ItemView itemView, SlideAdapter slideAdapter) {
                itemView.setText(R.id.tv_footer, "正在加载更多....");
                List<Bean> data2 = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    data2.add(new Bean("第" + i + "条新闻"));
                }
                slideAdapter.loadMore(data2);
                itemView.setText(R.id.tv_footer, "加载完成");
            }
        })
                .bind(itemBean)
                .into(recyclerview);
    }

    ItemBind<Bean> itemBean = new ItemBind<Bean>() {

        @Override
        public void onBind(ItemView itemView, final Bean bean, int i) {
            itemView.setText(R.id.tv_item, bean.title)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(SlideAdapterActivity.this, "Item点击", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setOnClickListener(R.id.tv_item, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(SlideAdapterActivity.this, bean.title, Toast.LENGTH_SHORT).show();
                        }
                    }).setOnClickListener(R.id.tv_left, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(SlideAdapterActivity.this, "标记", Toast.LENGTH_SHORT).show();
                }
            }).setOnClickListener(R.id.tv_right1, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(SlideAdapterActivity.this, "删除", Toast.LENGTH_SHORT).show();
                }
            }).setOnClickListener(R.id.tv_right2, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(SlideAdapterActivity.this, "置顶", Toast.LENGTH_SHORT).show();
                }
            }).setOnClickListener(R.id.tv_right3, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(SlideAdapterActivity.this, "已读", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
}
