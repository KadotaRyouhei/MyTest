package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import java.util.ArrayList;

import entity.SwipeCardBean;

/**
 * Created by shanliang on 2018/4/11.
 */

public class SwipeCardAdapter extends RecyclerView.Adapter<SwipeCardAdapter.CardHolder> {

    public ArrayList<SwipeCardBean> mData;
    public Context mContext;

    public SwipeCardAdapter(Context context, ArrayList<SwipeCardBean> list) {
        mContext = context;
        mData = list;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.swipe_card_item, null);
        CardHolder holder = new CardHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        setColor(holder.vItem, position);
        holder.tvItem.setText(position + "");
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class CardHolder extends RecyclerView.ViewHolder {

        public View vItem;
        public TextView tvItem;
        public CardHolder(View view) {
            super(view);
            vItem = view.findViewById(R.id.v_swipe_card);
            tvItem = (TextView) view.findViewById(R.id.tv_swipe_card);
        }
    }

    private void setColor(View view, int position) {
        if(view == null) {
            return;
        }
        int type = position % 3;
        if(type == 0) {
            view.setBackgroundResource(R.color.colorAccent);
        } else if(type == 1) {
            view.setBackgroundResource(R.color.colorPrimary);
        } else {
            view.setBackgroundResource(R.color.colorPrimaryDark);
        }
    }

    private int getRealNum(int position) {
        return position % mData.size();
    }

}
