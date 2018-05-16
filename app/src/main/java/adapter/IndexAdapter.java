package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shanliang.mvvmtest.R;

import java.util.List;

import entity.IndexBean;
import holder.IndexViewHolder;

/**
 * Created by shanliang on 2018/4/20.
 */

public class IndexAdapter extends RecyclerView.Adapter<IndexViewHolder> {

    private Context mContext;
    private List<IndexBean> mDataList;

    public IndexAdapter(Context context, List<IndexBean> list) {
        mContext = context;
        mDataList = list;
    }

    @Override
    public IndexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.index_item_view, null);
        IndexViewHolder holder = new IndexViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(IndexViewHolder holder, int position) {
        IndexBean indexBean = mDataList.get(position);
        holder.initIndex(mContext, indexBean);
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

}
