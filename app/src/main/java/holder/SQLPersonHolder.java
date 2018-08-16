package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import model.Person;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/15
 */
public class SQLPersonHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvAge;


    public SQLPersonHolder(View view) {
        super(view);
        tvName = (TextView) view.findViewById(R.id.tv_person_name);
        tvAge = (TextView) view.findViewById(R.id.tv_person_age);
    }

    public void initData(Person person) {
        if(person != null) {
            tvName.setText(person.name);
            tvAge.setText(person.age + "");
        }
    }


}
