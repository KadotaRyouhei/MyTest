package Utils;

import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by shanliang on 2018/6/7.
 */

public class MyUtils {

    public static void setText(TextView textView, String text) {
        if(textView == null) {
            return;
        }
        textView.setText(TextUtils.isEmpty(text) ? "" : text);
    }
}
