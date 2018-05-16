package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import java.util.ArrayList;

import entity.SwipeCardBean;

/**
 * Created by ls on 2017/11/25.
 */

public class UniversalAdapter extends RecyclerView.Adapter<UniversalAdapter.UniversalViewHolder> {
    public ArrayList<SwipeCardBean> mData;
    public Context context;

    public UniversalAdapter(ArrayList<SwipeCardBean> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @Override
    public UniversalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.swipe_card_item, null);
        UniversalViewHolder holder = new UniversalViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UniversalViewHolder holder, int position) {
        SwipeCardBean swipeCardBean = mData.get(position);
        int type = swipeCardBean.colorNum % 2;
        holder.recy_item_im.setBackgroundResource(type == 1? R.color.colorAccent : R.color.colorPrimary);
        holder.recy_item_tv.setText(swipeCardBean.colorNum + "");
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class UniversalViewHolder extends RecyclerView.ViewHolder {
        public TextView recy_item_tv;
        public View recy_item_im;

        public UniversalViewHolder(View itemView) {
            super(itemView);
            recy_item_im=itemView.findViewById(R.id.v_swipe_card);
            recy_item_tv=(TextView) itemView.findViewById(R.id.tv_swipe_card);
        }
    }
}