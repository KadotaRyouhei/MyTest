package customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shanliang.mvvmtest.R;

import entity.KillAssEntity;

/**
 * Created by shanliang on 2018/4/2.
 */

public class ProductListKillAssContentView extends RelativeLayout {

    private ImageView ivProduct;
    private TextView tvProductName;
    private TextView tvProductPrice;
    private TextView tvProductEvaluate;

    private KillAssEntity killAssEntity;

    public ProductListKillAssContentView (Context context) {
        this(context, null);
    }

    public ProductListKillAssContentView(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.product_list_kill_ass_content_item, this,
                true);
        initView();
    }

    private void initView() {
        ivProduct = (ImageView) findViewById(R.id.product_item_image);
        tvProductName = (TextView) findViewById(R.id.product_item_name);
        tvProductPrice = (TextView) findViewById(R.id.product_item_price);
        tvProductEvaluate = (TextView) findViewById(R.id.product_item_visitor_num);
    }

    public void setKillAssEntity(KillAssEntity kae) {
        if(kae != null) {
            if(!TextUtils.isEmpty(kae.kaData)) {
                tvProductName.setText(kae.kaData);
            } else {
                tvProductName.setText("默认价格");
            }

            tvProductPrice.setText("534");
            tvProductEvaluate.setText("好评");
        } else {
            tvProductName.setText("默认名称");
            tvProductPrice.setText("默认价格");
            tvProductEvaluate.setText("默认好评");
        }


    }


}
