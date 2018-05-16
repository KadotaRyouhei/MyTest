package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.KillAssAdapter;
import entity.KillAssEntity;
import entity.KillAssFloorEntity;

/**
 * Created by shanliang on 2018/3/27.
 */

public class KillAssSecondActivity extends Activity {

    private RecyclerView recyclerView;
    private KillAssAdapter killAssAdapter;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RelativeLayout rlTopTitle;
    private List<KillAssEntity> killAssEntityList;
    private List<KillAssFloorEntity> killAssFloorEntityList;
    private List<KillAssFloorEntity> killAssFloorEntityListSet;
    private IProductListKiallAssLoadMore loadMoreListener;
    private CollapsingToolbarLayoutState state;
    private LinearLayoutManager linearLayoutManager;
    private ServerDishOnScrollListener serverDishOnScrollListener;
    private int lastVisibleItem = 0;
    private int pageNum = 0;
    private boolean isLoadingMore = false;
    private boolean isCanNotLoadMore = false;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if(killAssFloorEntityListSet.size() > 0) {
                        killAssFloorEntityListSet.remove(killAssFloorEntityListSet.size() -1);
                    }
                    for(int i =0; i < 10; i ++ ) {
                        if(pageNum * 10 + i < killAssFloorEntityList.size()) {
                            KillAssFloorEntity kafe = killAssFloorEntityList.get(pageNum * 10 + i);
                            if(kafe != null) {
                                killAssFloorEntityListSet.add(kafe);
                            }
                        }
                    }

                    killAssFloorEntityListSet.add(buildLoadMoreEntity());

                    Toast.makeText(KillAssSecondActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
                    pageNum++;
                    killAssAdapter.notifyDataSetChanged();
                    killAssAdapter.notifyItemChanged(1,"dad");
                    isLoadingMore = false;
                    break;
                case 2:
                    if(killAssFloorEntityListSet.size() > 0) {
                        killAssFloorEntityListSet.remove(killAssFloorEntityListSet.size() -1);
                    }
                    killAssAdapter.notifyDataSetChanged();
                    Toast.makeText(KillAssSecondActivity.this,"已到最后一页",Toast.LENGTH_SHORT).show();
                    isCanNotLoadMore = true;
                    break;
                default:
                    break;
            }
            return true;
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kill_ass_second_activity);
        initView();
        initListener();
        initAdater();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        rlTopTitle = (RelativeLayout) findViewById(R.id.playButton);
    }

    private void initData() {
        killAssFloorEntityList = new ArrayList<>();
        KillAssFloorEntity kafe = new KillAssFloorEntity();
        kafe.type = 2;
        kafe.title_content = getResources().getString(R.string.kill_ass_title_content);
        killAssFloorEntityList.add(kafe);

        killAssEntityList = new ArrayList<>();
        int listSize = 47;
        for(int i = 0; i < listSize; i ++) {
            KillAssEntity ka = new KillAssEntity();
            ka.kaData = 1980 + i + "年的拉菲";
            killAssEntityList.add(ka);
        }
        makeFloorList(killAssFloorEntityList, killAssEntityList);

        if(loadMoreListener != null) {
            loadMoreListener.loadMore();
        }
    }


    private void initAdater() {
        killAssFloorEntityListSet = new ArrayList<>();
        killAssAdapter = new KillAssAdapter(KillAssSecondActivity.this, killAssFloorEntityListSet);
        killAssAdapter.setLoadMoreListener(loadMoreListener);
        linearLayoutManager = new LinearLayoutManager(KillAssSecondActivity.this);
        serverDishOnScrollListener = new ServerDishOnScrollListener();
        recyclerView.setOnScrollListener(serverDishOnScrollListener);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(killAssAdapter);
    }


    private void makeFloorList(List<KillAssFloorEntity> floorList, List<KillAssEntity> kaList) {
        int kaSize = kaList.size();
            for(int i =0, count = (kaSize+ 1) /2 ; i < count; i ++ ) {
                KillAssFloorEntity kafe = new KillAssFloorEntity();
                kafe.type = 1;
                if(i * 2 < kaSize) {
                    KillAssEntity kae = kaList.get(i * 2);
                    kafe.leftKaEntity = new KillAssEntity();
                    kafe.leftKaEntity.kaData = kae.kaData;
                }

                if(i * 2 + 1< kaSize) {
                    KillAssEntity kae = kaList.get(i * 2 + 1);
                    kafe.rightKaEntity = new KillAssEntity();
                    kafe.rightKaEntity.kaData = kae.kaData;
                }

                floorList.add(kafe);

            }
    }

    private KillAssFloorEntity buildLoadMoreEntity() {
        KillAssFloorEntity kafe = new KillAssFloorEntity();
        kafe.type = 3;
        return kafe;
    }

    private void initListener() {
        AppBarLayout app_bar=(AppBarLayout)findViewById(R.id.app_bar);
        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset == 0) {
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;//修改状态标记为展开
                        //collapsingToolbarLayout.setTitle("EXPANDED");//设置title为EXPANDED
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        rlTopTitle.setVisibility(View.VISIBLE);//隐藏播放按钮
                        state = CollapsingToolbarLayoutState.COLLAPSED;//修改状态标记为折叠
                    }
                } else {
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if(state == CollapsingToolbarLayoutState.COLLAPSED){
                            rlTopTitle.setVisibility(View.GONE);//由折叠变为中间状态时隐藏播放按钮
                        }
                        //collapsingToolbarLayout.setTitle("INTERNEDIATE");//设置title为INTERNEDIATE
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
                    }
                }
            }
        });

        loadMoreListener = new IProductListKiallAssLoadMore() {
            @Override
            public void loadMore() {

                if(!isCanNotLoadMore && !isLoadingMore) {
                    Toast.makeText(KillAssSecondActivity.this,"开始加载",Toast.LENGTH_SHORT).show();
                    isLoadingMore = true;
                    if(pageNum * 10 < killAssFloorEntityList.size()) {
                        handler.sendEmptyMessageDelayed(1,3000);
                    } else {
                        handler.sendEmptyMessageDelayed(2,3000);
                    }
                }

            }
        };

    }

    public class ServerDishOnScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == killAssAdapter.getItemCount()) {
                if (loadMoreListener != null) {
                   loadMoreListener.loadMore();
                }
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
        }
    }

}
