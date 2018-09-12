package entity;

import android.os.Handler;
import android.util.ArrayMap;
import android.util.LruCache;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Java基础类学习类，用于源码查看
 * Created by shanliang on 2018/8/17.
 */

public class JavaBase {

    private ArrayMap<String, String> map = new ArrayMap<>();
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private HashSet<String> strings = new HashSet<>();
    private LruCache<String, String> lruCache = new LruCache<>(16);
    private Handler handler = new Handler();
    private LinkedHashSet linkedHashSet = new LinkedHashSet();
    private TreeSet treeSet = new TreeSet();
    private TreeMap treeMap = new TreeMap();

}
