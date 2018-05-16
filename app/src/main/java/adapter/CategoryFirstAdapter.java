package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import java.util.ArrayList;

import holder.CategoryFirstHolder;
import model.CategoryEntity;

/**
 * Created by shanliang on 2018/4/23.
 */

public class CategoryFirstAdapter extends BaseAdapter {

    private ArrayList<CategoryEntity> LeftText;
    private Context mContext;

    public void setCurrentItem(int currentItem) {
        this.currentItem = currentItem;
    }

    private int currentItem = 0;

    public void setListener(CategoryFirstListener listener) {
        this.listener = listener;
    }

    private CategoryFirstListener listener;

    public CategoryFirstAdapter(ArrayList<CategoryEntity> LeftText, Context context) {
        this.LeftText = LeftText;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return LeftText.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        CategoryFirstHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.category_first_item, null);
            viewHolder = new CategoryFirstHolder();
            viewHolder.tvCategoryFirst = (TextView) convertView.findViewById(R.id.tv_category_first);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CategoryFirstHolder) convertView.getTag();
        }

        CategoryEntity ce = LeftText.get(position);
        viewHolder.tvCategoryFirst.setText(ce.cName);
        viewHolder.tvCategoryFirst.setTextColor(mContext.getResources().getColor(currentItem == position ? R.color.colorAccent : R.color.colorPrimaryGray));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onClick(position);
                }
            }
        });


        return convertView;
    }

    public void onNext(int position) {
        if(listener != null) {
            listener.onClick(position);
        }
    }


    public interface CategoryFirstListener {
        void onClick(int position);
    }
}
