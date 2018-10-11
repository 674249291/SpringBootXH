package com.xj.springbeanlive;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 这样在 springLifeCycleAware 这个 bean 初始化会就会调用 setApplicationContext 方法，并可以获得 applicationContext 对象。
 * 可以通过applicationcontext是IOC的高级容器，可以获取所有的实例
 * @Author: XIONGJUN
 * @Date: 2018/10/11 10:52
 * @Description:
 */
public class SpringLifeCycleAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("获取到的上下文的");
    }
}
