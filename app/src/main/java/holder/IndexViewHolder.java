package holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.shanliang.mvvmtest.R;

import entity.IndexBean;

/**
 * Created by shanliang on 2018/4/20.
 */

public class IndexViewHolder extends RecyclerView.ViewHolder {

    private TextView tvGoIndex;

    public IndexViewHolder(View view) {
        super(view);
        tvGoIndex = (TextView) view.findViewById(R.id.tv_go_index);
    }

    public void initIndex(final Context context, final IndexBean indexBean) {
        tvGoIndex.setText(indexBean.name);
        tvGoIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,indexBean.destClass);
                context.startActivity(intent);
            }
        });

    }
}
