package com.yilvs.myapplication.mvp.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yilvs.myapplication.R;
import com.yilvs.myapplication.adapter.ImageListAdapter;
import com.yilvs.myapplication.entity.ImageEntity;
import com.yilvs.myapplication.entity.ResultParent;
import com.yilvs.myapplication.framework.factory.CreatePresenter;
import com.yilvs.myapplication.framework.view.AbstractMvpActivitiy;
import com.yilvs.myapplication.framework.view.base.BaseMvpView;
import com.yilvs.myapplication.mvp.presenter.ImageListPresenter;
import com.yilvs.myapplication.view.DividerGridItemDecoration;
import com.yilvs.myapplication.view.DividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * description:ImageList
 *
 * @autour yilv & version: v1.0 & date: ----/--/--
 */
@CreatePresenter(ImageListPresenter.class)
public class ImageListActivity extends AbstractMvpActivitiy<BaseMvpView, ImageListPresenter> implements BaseMvpView<ResultParent<List<ImageEntity>>> {

    @BindView(R.id.et_query)
    EditText etQuery;
    @BindView(R.id.tv_query)
    TextView tvQuery;
    @BindView(R.id.tv_change_list)
    TextView tvChangeList;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private String mQueryContent;
    private ImageListPresenter mPresenter;

    //查询条件
    private String mQuery = "mobike";
    //
    private String mPn;
    //
    private int mSn;

    private ImageListAdapter mImageListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    protected void initView() {
        setContentView(R.layout.activity_image_list);
        ButterKnife.bind(this);

        //刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshData();
            }
        });
        //加载更多
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                mSn++;
                mPresenter.getImageList(mQuery, String.valueOf(mSn), mPn);
            }
        });
    }

    /**
     * 刷新数据
     */
    private void refreshData() {
        mSn = 0;
        mPn = "50";
        mPresenter.getImageList(mQuery, String.valueOf(mSn), mPn);
    }

    protected void initData() {
        mPresenter = getMvpPresenter();

        refreshLayout.autoRefresh();
    }

    @Override
    public void resultSuccess(ResultParent<List<ImageEntity>> result) {
        if (result == null) {
            return;
        }

        refreshLayout.finishRefresh();
        if (!result.isEnd()) {
            mSn++;
            refreshLayout.setEnableLoadMore(true);
        } else {
            refreshLayout.setEnableLoadMore(false);
        }
        if (mImageListAdapter == null) {
            mImageListAdapter = new ImageListAdapter(this, result.getList());
            mRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
            mRecyclerview.addItemDecoration(new DividerGridItemDecoration(this, 10, 0xffffffff));
            mRecyclerview.setAdapter(mImageListAdapter);
        } else {
            mImageListAdapter.addList(result.getList());
        }
    }

    @Override
    public void resultFailure(String result) {
        if (!TextUtils.isEmpty(result)) {
            Toast.makeText(this, result, 1000);
        }
    }

    @OnClick(R.id.tv_query)
    public void onTvQueryClicked() {
        mQueryContent = etQuery.getText().toString();
        if (TextUtils.isEmpty(mQueryContent)) {
            mQueryContent = "";
        }
        mImageListAdapter.getData().clear();
        mPresenter.getImageList(mQueryContent, String.valueOf(mSn), mPn);
    }

    /**
     * 切换瀑布流
     */
    @OnClick(R.id.tv_change_list)
    public void onChangeListClicked() {
        if (tvChangeList.getText().equals("切换为瀑布流")) {
            mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            mImageListAdapter.notifyDataSetChanged();
            tvChangeList.setText("切换为列表");
        } else {
            mRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
            mImageListAdapter.notifyDataSetChanged();
            tvChangeList.setText("切换为瀑布流");
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {
    }
}
