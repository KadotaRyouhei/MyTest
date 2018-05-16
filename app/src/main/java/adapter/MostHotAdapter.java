package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shanliang.mvvmtest.R;

import java.util.List;

import entity.KillAssFloorEntity;
import holder.MostHotHolder;

/**
 * Created by shanliang on 2018/5/4.
 */

public class MostHotAdapter extends RecyclerView.Adapter<MostHotHolder> {

    private Context mContext;
    private List<String>  dataList;

    public MostHotAdapter(Context context, List<String> list) {
        mContext = context;
        dataList = list;
    }


    @Override
    public MostHotHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MostHotHolder viewHolder = null;
        if(viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.rl_most_hot, null);
            viewHolder = new MostHotHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MostHotHolder holder, int position) {
        holder.initData(mContext);
    }

    @Override
    public int getItemViewType(int position) {

        return 1;
    }

    @Override
    public int getItemCount()
    {
        if(dataList != null) {
            return dataList.size();//获取数据的个数
        } else {
            return 0;
        }

    }
}
