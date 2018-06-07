package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shanliang.mvvmtest.R;

import java.util.List;

import commoninterface.LeftClickListener;
import entity.CategoryLeftBean;
import holder.CategoryLeftViewHolder;


/**
 * Created by shanliang on 2018/6/7.
 */

public class CategoryLeftAdapter extends RecyclerView.Adapter<CategoryLeftViewHolder> {

    private Context mContext;

    private List<CategoryLeftBean> mDataList;

    private LeftClickListener leftClickListener;

    public CategoryLeftAdapter(Context context) {
        mContext = context;
    }

    public void setDataList(List<CategoryLeftBean> mDataList) {
        this.mDataList = mDataList;
        notifyDataSetChanged();
    }

    public void setLeftClickListener(LeftClickListener leftClickListener) {
        this.leftClickListener = leftClickListener;
    }

    @Override
    public CategoryLeftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_left_item_view, parent, false);
        CategoryLeftViewHolder holder = new CategoryLeftViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryLeftViewHolder holder, final int position) {
        final int type = position % 3;
        CategoryLeftBean categoryLeftBean = mDataList.get(position);
        holder.setName(categoryLeftBean.name);
        holder.rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leftClickListener != null) {
                    leftClickListener.getRightData(type);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }
}
