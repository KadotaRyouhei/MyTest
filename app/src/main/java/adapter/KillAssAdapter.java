package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shanliang.mvvmtest.IProductListKiallAssLoadMore;
import customview.ProductListKillAssContentView;
import com.example.shanliang.mvvmtest.R;

import java.util.List;

import entity.KillAssEntity;
import entity.KillAssFloorEntity;

/**
 * Created by shanliang on 2018/3/28.
 */

public class KillAssAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<KillAssFloorEntity> floorEntityList;
    private static int TYPE_CONTENT = 1;
    private static int TYPE_TITLE = 2;
    private static int TYPE_LOAD_MORE = 3;
    private IProductListKiallAssLoadMore loadMoreListener;

    public KillAssAdapter(Context context, List<KillAssFloorEntity> floorList) {
        mContext = context;
        floorEntityList = floorList;
    }

    public void setLoadMoreListener(IProductListKiallAssLoadMore listener) {
        loadMoreListener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == TYPE_TITLE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_list_kill_ass_recycler_item_title, parent, false);
            viewHolder = new TitleViewHolder(view);
        } else if(viewType == TYPE_CONTENT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_list_kill_ass_recycler_item_content, parent,
                    false);
            viewHolder = new ContentViewHolder(view);
        } else if(viewType == TYPE_LOAD_MORE){
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_list_kill_ass_load_more, parent,
                    false);
            viewHolder = new LoadMoreViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_list_kill_ass_recycler_item_content, parent,
                    false);
            viewHolder = new ContentViewHolder(view);
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof ContentViewHolder) {
                KillAssFloorEntity kafe = floorEntityList.get(position);
                if(kafe != null ) {
                    ((ContentViewHolder) holder).setLeftContent(kafe.leftKaEntity);
                }
                if(kafe != null ) {
                    ((ContentViewHolder) holder).setRightContent(kafe.rightKaEntity);
                }
            } else if(holder instanceof TitleViewHolder) {
                KillAssFloorEntity kafe = floorEntityList.get(position);
                if(kafe != null && !TextUtils.isEmpty(kafe.title_content)) {
                    ((TitleViewHolder) holder).setText(kafe.title_content);
                }
            } else if(holder instanceof LoadMoreViewHolder) {
                //((LoadMoreViewHolder)holder).showLoadMore();
            } else {

            }
    }

    @Override
    public int getItemViewType(int position) {
        if(floorEntityList != null && floorEntityList.get(position) != null) {
            return floorEntityList.get(position).type;
        }
        return TYPE_CONTENT;
    }
    @Override
    public int getItemCount()
    {
        if(floorEntityList != null) {
            return floorEntityList.size();//获取数据的个数
        } else {
            return 0;
        }

    }

    class ContentViewHolder extends RecyclerView.ViewHolder
    {
        private ProductListKillAssContentView plkacvLeft;
        private ProductListKillAssContentView plkacvRight;


        public ContentViewHolder(View view)
        {
            super(view);
            plkacvLeft = (ProductListKillAssContentView) view.findViewById(R.id.plkacv_left);
            plkacvRight = (ProductListKillAssContentView) view.findViewById(R.id.plkacv_right);
        }

        public void setLeftContent(KillAssEntity kae) {
            plkacvLeft.setKillAssEntity(kae);
        }

        public void setRightContent(KillAssEntity kae) {
            plkacvRight.setKillAssEntity(kae);
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv;

        public TitleViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_title_description);

        }
        public void setText(String des) {
            if(tv != null) {
                tv.setText(des);
            }
        }
    }

    class LoadMoreViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv;
        private boolean hasShow = false;

        public LoadMoreViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_load_more);

        }
        public void showLoadMore() {
            if(!hasShow) {
                Toast.makeText(mContext,"开始加载下一页数据",Toast.LENGTH_SHORT).show();
                hasShow = true;
                if(loadMoreListener != null) {
                    loadMoreListener.loadMore();
                }
            }

        }
    }








}
