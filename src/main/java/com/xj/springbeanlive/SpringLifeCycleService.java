package com.xj.springbeanlive;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 还可以实现 InitializingBean,DisposableBean 这两个接口，也是在初始化以及销毁阶段调用：
 * @Author: XIONGJUN
 * @Date: 2018/10/11 10:39
 * @Description:
 */
public class SpringLifeCycleService implements InitializingBean,DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringLifeCycleService 销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("springlifecyceservice 创建");
    }

}
