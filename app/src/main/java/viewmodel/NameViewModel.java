package viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by shanliang on 2018/6/1.
 */

public class NameViewModel extends ViewModel{

    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
        if(mCurrentName == null) {
            mCurrentName = new MutableLiveData<String>();
        }
        return mCurrentName;
    }
}
