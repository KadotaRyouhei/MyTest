package baseinterface;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;

import fragment.MergeFragment;
import fragment.NormalFragment;
import fragment.RecommendFragment;

/**
 * Created by shanliang on 2018/6/7.
 */

public class FragmentCreator {
    public static Fragment getFragment(int type, Activity activity){
        Fragment fragment = null;
        switch (type) {
            case 0:
                fragment = new RecommendFragment();
                break;
            case 1:
                fragment = new NormalFragment();
                break;
            case 2:
                fragment = new MergeFragment().init(activity);
                break;
            default:
                fragment = new NormalFragment();
                break;
        }
        return fragment;
    }
}
