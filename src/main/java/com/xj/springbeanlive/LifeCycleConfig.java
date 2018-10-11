package com.xj.springbeanlive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义方法用于初始化和销毁阶段调用
 * @Author: XIONGJUN
 * @Date: 2018/10/11 10:47
 * @Description:
 */
@Configuration
public class LifeCycleConfig {

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public SpringLifeCycle create(){
      SpringLifeCycle springLifeCycle = new SpringLifeCycle();
      return springLifeCycle;
    }

}


class SpringLifeCycle{
    private final static Logger LOGGER = LoggerFactory.getLogger(SpringLifeCycle.class);
    public void start(){
        LOGGER.info("SpringLifeCycle start");
    }
    public void destroy(){
        LOGGER.info("SpringLifeCycle destroy");
    }
}