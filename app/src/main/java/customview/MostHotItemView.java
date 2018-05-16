package customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import entity.HorizonItemBean;

/**
 * Created by shanliang on 2018/5/3.
 */

public class MostHotItemView extends LinearLayout {

    private TextView tvContent;
    private ImageView ivContent;
    private Context mContext;

    public MostHotItemView(Context context) {
        this(context, null);
    }

    public MostHotItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.most_hot_child_item, this, true);
        tvContent = (TextView) view.findViewById(R.id.tv_most_hot_child_item);
        ivContent = (ImageView) view.findViewById(R.id.iv_most_hot_child_item);
    }

    public void initData(HorizonItemBean item) {
        setText(item);
    }

    private void setText(HorizonItemBean item) {
        if(item != null && !TextUtils.isEmpty(item.name)) {
            tvContent.setText(item.name);
        } else {
            tvContent.setText("");
        }
    }


}
