package factory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.shanliang.mvvmtest.R;

import holder.TitleViewHolder;
import model.SecondCategory;

/**
 * Created by shanliang on 2018/6/4.
 * holder工厂，提供各种holder实例化并且返回响应的convertView
 */

public class HolderFactory {

    private Context mContext;

    private LayoutInflater layoutInflater;

    public HolderFactory(Context context) {
        mContext = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public View initTitleHolderAndReturnView(View convertView, SecondCategory data, int position) {
        TitleViewHolder titleViewHolder = null;
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.second_category_title_layout,null);
            titleViewHolder = new TitleViewHolder();
            titleViewHolder.leftTitle = convertView.findViewById(R.id.tv_title_name);
            titleViewHolder.rightContent = convertView.findViewById(R.id.tv_content);
        } else {
            Object tag = convertView.getTag();
            if(tag instanceof TitleViewHolder) {
                titleViewHolder = (TitleViewHolder) tag;
            }
        }

        if(titleViewHolder != null) {
            titleViewHolder.init(data, position);
        }

        return convertView;
    }
}
