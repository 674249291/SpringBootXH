package com.xj.springbeanlive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: XIONGJUN
 * @Date: 2018/10/11 9:55
 * @Description:
 */
@Component
public class AnnotationBean {

    private final static Logger LOGGER = LoggerFactory.getLogger(AnnotationBean.class);

    /**
     * 类创建被调用
     */
    @PostConstruct
    public void start(){
        LOGGER.info("》》》》》》》AnnotationBean start");
    }

    /**
     * 销毁被调用
     */
    @PreDestroy
    public void destroy(){
        LOGGER.info("》》》》》》》AnnotationBean destroy");
    }

}
