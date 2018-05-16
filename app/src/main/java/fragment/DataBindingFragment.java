package fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shanliang.mvvmtest.R;
import com.example.shanliang.mvvmtest.databinding.ModuleFragmentDatabindingBinding;
import entity.People;

/**
 * Created by shanliang on 2018/2/6.
 */

public class DataBindingFragment extends Fragment {

    private People people;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ModuleFragmentDatabindingBinding binding = DataBindingUtil.inflate(inflater, R.layout.module_fragment_databinding,container,false);
        people = new People("ShiLinLin",28,false);
        binding.setPeople(people);
        return binding.getRoot();
    }


}
