package fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shanliang.mvvmtest.R;

/**
 * Created by shanliang on 2018/1/26.
 */

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        getActivity().getWindow().setBackgroundDrawable(null);
        //hideActivityBackground();
        return view;
    }

    private void hideActivityBackground() {
        ((ViewGroup)getActivity().findViewById(android.R.id.content)).getChildAt(0).setBackgroundResource(0);
    }
}
