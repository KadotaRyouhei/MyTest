package viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by shanliang on 2018/6/4.
 */

public class TitleViewModel extends ViewModel {

    private MutableLiveData<String> titleName;

    public MutableLiveData<String> getTitleName() {
        if(titleName == null) {
            titleName = new MutableLiveData<String>();
        }
        return titleName;
    }
}
