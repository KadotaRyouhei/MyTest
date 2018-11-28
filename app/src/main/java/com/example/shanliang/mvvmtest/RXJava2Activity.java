package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.LinkedList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import model.MessageEvent;

/**
 * Created by shanliang on 2018/5/10.
 */

public class RXJava2Activity extends Activity {

    private final String TAG = "RXJava2Activity";

    private TextView tvRun, tvTestEventBus;

    private View.OnClickListener onClickListener;

    private Observable<Integer> observable;

    private Observable<JSONObject> observableJSON;

    private Observer<Integer> observer;

    private LruCache<String,Bitmap> lruCache;

    private LinkedList<String> linkedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_second_layout);
        init();
        initObserver();
        initListener();

    }


    private void init() {
        tvRun = (TextView) findViewById(R.id.tv_run);
        tvTestEventBus = (TextView) findViewById(R.id.tv_event_bus_test);
    }

    private void initListener() {
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //observable.subscribe(observer);
                //initObserver2();
            }
        };
        tvRun.setOnClickListener(onClickListener);

        tvTestEventBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("欧蕾哇，海邹库"));
                finish();
            }
        });

    }

    private void initObserver3() {
        observableJSON = Observable.create(new ObservableOnSubscribe<JSONObject>() {
            @Override
            public void subscribe(ObservableEmitter<JSONObject> emitter) throws Exception {

            }
        });
    }

    private void initObserver() {
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });

        observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext" + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        };


    }

    private void initObserver2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "emitter 1");
                emitter.onNext(1);
                Log.d(TAG, "emitter 2");
                emitter.onNext(2);
                Log.d(TAG, "emitter 3");
                emitter.onNext(3);
                Log.d(TAG, "on complete");
                emitter.onComplete();
                Log.d(TAG, "emitter 4");
                emitter.onNext(4);
            }
        }).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {

            private Disposable mDisposable;
            private int i = 0;

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
                mDisposable = d;
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "onNext: " + value);
                i++;
                if(i == 2) {
                    Log.d(TAG, "dispose");
                    mDisposable.dispose();
                    Log.d(TAG, "isDisposed : " + mDisposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        });
    }


}
