package com.xj.jvm;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 设计思路是：用一个HashMap来保存图片的路径 和 相应图片对象关联的软引用之间的映射关系，
 * 在内存不足时，JVM会自动回收这些缓存图片对象所占用的空间，从而有效地避免了OOM的问题。在Android开发中对于大量图片下载会经常用到。
 * 当然这里我们把缓存替换策略交给了JVM去执行，这是一种比较简单的处理方法。
 * Created by xiong on 2018/3/19.
 */
public class BitmapToCache {

    private Map<String, SoftReference<String>> map = new HashMap<>();

    public void addStringToCache(String path){
        SoftReference softReference = new SoftReference(path);
        map.put(path,softReference);
    }

    public String getStringToCache(String path){
        // 从缓存中取软引用的Bitmap对象
        SoftReference<String> softBitmap = map.get(path);
        // 判断是否存在软引用
        if (softBitmap == null) {
            return null;
        }
        // 取出Bitmap对象，如果由于内存不足Bitmap被回收，将取得空
        String bitmap = softBitmap.get();
        return bitmap;
    }

}
