package com.xj.xs.ThreadDemo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by xiong on 2018/2/11.
 */
public class CacheDemo {

    private Map<String,Object> cache = new HashMap<String,Object>();

    public static void main(String[] args) {
    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public Object getData(String key){
        Object value = null;
        try{
            rwl.readLock().lock();
            value = cache.get(key);
            if(value == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    //如果同时读到写锁的话，数据就会被修改了，所以存在的话就不会被修改了
                    if (value == null) {
                        value = "query DB"; //去数据库中查询数据
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }

        return value;
    }
}
