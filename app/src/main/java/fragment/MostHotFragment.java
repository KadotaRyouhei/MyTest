package fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shanliang.mvvmtest.MostHotActivity;
import com.example.shanliang.mvvmtest.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MostHotAdapter;

/**
 * Created by shanliang on 2018/5/4.
 */

public class MostHotFragment extends Fragment {

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    private Context mContext;
    private RecyclerView recyclerView;
    private View mLeftMenu;
    private MostHotAdapter adapter;
    private List<String> dataList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.most_hot_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_most_hot);
        initData();


    }

    private void initData() {
        for(int i = 0; i < 10; i ++) {
            dataList.add("第" + i + "份鳗鱼饭");
        }
        adapter = new MostHotAdapter(mContext, dataList);
        LinearLayoutManager llm = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

}
