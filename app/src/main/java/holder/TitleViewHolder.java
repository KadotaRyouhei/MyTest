package holder;

import android.view.View;
import android.widget.TextView;

import model.SecondCategory;

/**
 * Created by shanliang on 2018/6/4.
 */

public class TitleViewHolder {

    /**
     * 布局根view，用于recyclerView中返回使用
     */
    public View rootView;

    /**
     * 左侧标题
     */
    public TextView leftTitle;
    /**
     * 右侧配置内容
     */
    public TextView rightContent;


    /**
     * @param data
     * @param position
     * 数据与控件的设置，通过livedata绑定实现
     */
    public void init(SecondCategory data, int position) {


    }


}
