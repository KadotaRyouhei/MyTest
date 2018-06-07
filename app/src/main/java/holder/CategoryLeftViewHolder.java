package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import Utils.MyUtils;

/**
 * Created by shanliang on 2018/6/7.
 */

public class CategoryLeftViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;

    public RelativeLayout rlContainer;

    public CategoryLeftViewHolder(View view) {
        super(view);
        tvName = (TextView)view.findViewById(R.id.text);
        rlContainer = (RelativeLayout) view.findViewById(R.id.rl_left_container);
    }

    public void setName(String name) {
        MyUtils.setText(tvName, name);
    }

}
