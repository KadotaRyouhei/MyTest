package adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shanliang.mvvmtest.R;

import Utils.LocalCupboard;
import holder.SQLPersonHolder;
import model.Book;
import model.Person;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/15
 */
public class SQLiteAdapter extends RecyclerView.Adapter<SQLPersonHolder> {

    private final Context context;
    private final CursorAdapter cursorAdapter;

    public SQLiteAdapter(Context context) {
        this.context = context;

        cursorAdapter = new CursorAdapter(SQLiteAdapter.this.context, null, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_sql_person, parent, false);
                SQLPersonHolder holder = new SQLPersonHolder(itemView);
                itemView.setTag(holder);
                return itemView;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                final Book person = LocalCupboard.getInstance().withCursor(cursor).get(Book.class);
                final SQLPersonHolder holder = (SQLPersonHolder) view.getTag();
                holder.initData(person);
            }
        };
    }


    @Override
    public int getItemCount() {
        return cursorAdapter.getCount();
    }

    @Override
    public void onBindViewHolder(SQLPersonHolder holder, int position) {
        cursorAdapter.getCursor().moveToPosition(position);
        cursorAdapter.bindView(holder.itemView, context, cursorAdapter.getCursor());
    }

    @Override
    public SQLPersonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = cursorAdapter.newView(context, cursorAdapter.getCursor(), parent);
        return new SQLPersonHolder(v);
    }

    public void swapCursor(Cursor newCursor) {
        cursorAdapter.swapCursor(newCursor);
        notifyDataSetChanged();
    }

}
