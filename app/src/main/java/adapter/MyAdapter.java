package adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shanliang.mvvmtest.BR;
import com.example.shanliang.mvvmtest.R;
import com.example.shanliang.mvvmtest.databinding.ItemRecyclerviewMainBinding;

import java.util.ArrayList;

import entity.People;

/**
 * Created by shanliang on 2018/3/12.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<People> mData = new ArrayList<>();
    private Context mContext;
    public MyAdapter(Context context, ArrayList<People> data) {
        mContext = context;
        mData.addAll(data);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ItemRecyclerviewMainBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_recyclerview_main, viewGroup, false);

        ViewHolder holder = new ViewHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.getBinding().setVariable(BR.people,mData.get(i));
        if(mContext != null) {
            viewHolder.getBinding().tvBottom.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        }

        viewHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }




    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerviewMainBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setBinding(ItemRecyclerviewMainBinding binding) {
            this.binding = binding;
        }

        public ItemRecyclerviewMainBinding getBinding() {
            return this.binding;
        }

    }
}
