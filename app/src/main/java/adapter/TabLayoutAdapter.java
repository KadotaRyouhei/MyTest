package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shanliang.mvvmtest.R;
import java.util.List;
import holder.TabTitleViewHolder;

/**
 * Created by shanliang on 2018/6/5.
 */

public class TabLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private static int TYPE_TITLE = 1;

    private List<String> datas;

    public TabLayoutAdapter(Context context) {
        mContext = context;
    }


    public void setData(List<String> list) {
        datas = list;
        notifyDataSetChanged();
    }

    private boolean isDataEnable() {
        return datas != null && datas.size() > 0;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == TYPE_TITLE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.tab_title_layout, parent, false);
            viewHolder = new TabTitleViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TabTitleViewHolder && isDataEnable()) {
            String title = datas.get(position);
            TabTitleViewHolder tabTitleViewHolder = (TabTitleViewHolder)holder;
            tabTitleViewHolder.setText(title);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return TYPE_TITLE;
    }
    @Override
    public int getItemCount()
    {
        return isDataEnable() ? datas.size() : 0;

    }




}
