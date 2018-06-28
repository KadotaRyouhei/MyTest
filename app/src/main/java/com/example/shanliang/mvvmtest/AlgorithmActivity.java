package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanliang on 2018/6/28.
 */

public class AlgorithmActivity extends Activity {

    private TextView tvOutTwo, tvOutOne, tvRun, tvOutThree, tvOutFour;
    private EditText etPutOne,etPutTwo;

    private int countN = 0, sortK = 0, dataLength = 0;
    private List<Integer> dataList = new ArrayList<>();
    private int currentLISCount = 0;
    private List<Integer> currentLISList;
    private List<List<Integer>> currentLISListList = new ArrayList<>();

    private List<Integer> indexLISList = new ArrayList<>();

    private SparseArray<List<List<Integer>>> sparseArray = new SparseArray<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algorithm_activity);
        init();
        initListener();
    }

    private void init() {
        etPutOne = (EditText) findViewById(R.id.et_put_one);
        etPutTwo = (EditText) findViewById(R.id.et_put_two);
        tvOutOne = (TextView) findViewById(R.id.tv_out_one);
        tvOutTwo = (TextView) findViewById(R.id.tv_out_two);
        tvOutThree = (TextView) findViewById(R.id.tv_out_three);
        tvOutFour = (TextView) findViewById(R.id.tv_out_four);
        tvRun = (TextView) findViewById(R.id.tv_run);
    }

    private void initListener() {
        tvRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
                getNAndK();
                getDataList();
                showOne();
                showTwo();
                showThree();
                showFour();
            }
        });
    }

    private void getNAndK() {
        String nk = etPutOne.getText().toString().trim();
        String[] nkArray = nk.split(",");
        if(nkArray != null && nkArray.length > 1) {
            countN = Integer.valueOf(nkArray[0]);
            sortK = Integer.valueOf(nkArray[1]);
        }
    }

    private void getDataList() {
        String data = etPutTwo.getText().toString().trim();
        String[] dataArray = data.split(",");
        if(dataArray != null && dataArray.length > 0) {
            dataLength = dataArray.length;
            for(int i = 0; i < dataLength; i ++) {
                Integer num = Integer.valueOf(dataArray[i]);
                dataList.add(num);
            }
        }
    }

    private void clearAll() {
        dataList.clear();
        currentLISListList.clear();
        sparseArray.clear();
    }

    private void showOne() {
        tvOutOne.setText("N为：" + countN + " K为：" + sortK);
    }

    private void showTwo() {
        tvOutTwo.setText("数据第一位为：" + dataList.get(0));
    }

    private void showThree() {
        getMAXLISList();
        tvOutThree.setText("" + sparseArray.size());
    }

    private void showFour() {
        if(sparseArray != null && sparseArray.size() > 0) {
            int spaArraySize = sparseArray.size();
            List<List<Integer>> maxList = sparseArray.get(spaArraySize);
            if(maxList != null && maxList.size() > 0 && sortK - 1  < maxList.size()) {
                List<Integer> answerSort = maxList.get(sortK - 1);
                StringBuilder stringBuilder = new StringBuilder();
                int answerSize = answerSort.size();
                for(int i = 0; i < answerSize; i ++) {
                    stringBuilder.append(answerSort.get(i));
                    if(i != answerSize - 1){
                        stringBuilder.append(",");
                    }
                }

                tvOutFour.setText(stringBuilder.toString());
            }
        }
    }


    private void getMAXLISList() {
        for(int i = 0; i < dataLength - 1; i ++) {
                List<Integer> list = new ArrayList<>();
                list.add(dataList.get(i));
                getNext(i,i + 1,list);
        }
    }

    private List<Integer> getLISList(int startIndex, int secondIndex) {
        List<Integer> lisList = new ArrayList<>();
        int maxNum = dataList.get(startIndex);
        lisList.add(maxNum);
        for(int i = secondIndex; i < dataLength; i ++) {
            int num = dataList.get(i);
            if(num > maxNum) {
                maxNum = num;
                lisList.add(num);
            }
        }
        return lisList;
    }


    private void getNext(int numIndex, int startIndex, List<Integer> totalList) {
        int currentNum = dataList.get(numIndex);
        for(int i = startIndex; i < dataLength; i ++) {
            int num = dataList.get(i);
            if(num > currentNum) {
                List<Integer> nextList = new ArrayList<>();
                nextList.addAll(totalList);
                nextList.add(num);
                getNext(i,i + 1,nextList);
            }
        }
        if(totalList.size() > 0) {
            int length = totalList.size();
            if(sparseArray.get(length) == null) {
                List<List<Integer>> spaArrayList = new ArrayList<>();
                sparseArray.put(length, spaArrayList);
            }
            //sparseArray.get(length).add(totalList);
            sortInsert(sparseArray.get(length), totalList, length);
        }
    }

    private void sortInsert(List<List<Integer>> oriArrayList,List<Integer> addList, int length) {
        boolean isAdded = false;
        if(oriArrayList.size()== 0) {
            oriArrayList.add(addList);
        } else {
            for(int i = 0, size = oriArrayList.size(); i < size; i ++) {
                if(isAdded) {
                    break;
                }
                List<Integer> oriList = oriArrayList.get(i);
                for(int j = 0; j < length; j ++ ) {
                    int oriNum = oriList.get(j);
                    int addNum = addList.get(j);
                    if(addNum < oriNum) {
                        oriArrayList.add(i,addList);
                        isAdded = true;
                        break;
                    } else if( addNum == oriNum) {
                        continue;
                    } else {
                        break;
                    }
                }
            }

            if(!isAdded) {
                oriArrayList.add(addList);
            }
        }
    }







}
