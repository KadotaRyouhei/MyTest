package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

/**
 * Created by shanliang on 2018/6/5.
 */

public class TabTitleViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;

    public TabTitleViewHolder(View view)
    {
        super(view);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);

    }
    public void setText(String des) {
        if(tvTitle != null) {
            tvTitle.setText(des);
        }
    }
}
