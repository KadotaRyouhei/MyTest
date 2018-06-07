package baseinterface;

import android.support.v4.app.Fragment;

import fragment.MergeFragment;
import fragment.NormalFragment;
import fragment.RecommendFragment;

/**
 * Created by shanliang on 2018/6/7.
 */

public class FragmentCreator {
    public static Fragment getFragment(int type){
        Fragment fragment = null;
        switch (type) {
            case 0:
                fragment = new RecommendFragment();
                break;
            case 1:
                fragment = new NormalFragment();
                break;
            case 2:
                fragment = new MergeFragment();
                break;
            default:
                fragment = new NormalFragment();
                break;
        }
        return fragment;
    }
}
