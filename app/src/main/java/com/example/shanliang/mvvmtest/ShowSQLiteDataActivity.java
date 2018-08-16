package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import Utils.DBManager;
import adapter.SQLiteAdapter;
import model.Book;
import model.Person;
import nl.qbusict.cupboard.Cupboard;
import provider.BookProvider;
import provider.PersonContentProvider;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/15
 */
public class ShowSQLiteDataActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private RecyclerView mRecyclerView;

    private SQLiteAdapter sqLiteAdapter;

    private DBManager dbManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sql_data);
        initView();
        initAdapter();
        initData();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_sql);
    }

    private void initAdapter() {
        sqLiteAdapter = new SQLiteAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(sqLiteAdapter);
    }


    private void initData() {
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader loader = new CursorLoader(ShowSQLiteDataActivity.this);
        loader.setUri(BookProvider.BOOK_URI);
        loader.setProjection(Book.PARTIAL_PROJECTION);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        sqLiteAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        sqLiteAdapter.swapCursor(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(0, null, this);
    }
}
