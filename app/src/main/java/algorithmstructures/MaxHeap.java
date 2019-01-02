package algorithmstructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanliang on 2018/12/7.
 */

public class MaxHeap<T extends Comparable<T>> {
    private List<T> mHeap;

    public MaxHeap() {
        mHeap = new ArrayList<>();
    }

    protected void filterup(int start) {
        int c = start;
        int p = (c -1) /2;
        T tmp = mHeap.get(c);
        while(c > 0) {
            int cmp = mHeap.get(p).compareTo(tmp);
            if(cmp >= 0) {
                break;
            } else {
                mHeap.set(c,mHeap.get(p));
                c = p;
                p = (c -1) /2;
            }
        }
        mHeap.set(c,tmp);
    }
}
