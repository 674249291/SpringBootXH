package com.xj.xs.weixin;

import com.xj.xs.utils.HttpClientUtil;

/**
 * Created by xiong on 2018/2/6.
 */
public class GoodMessage {

    public static void main(String[] args) {
        getMessage();
    }

    public static void getMessage(){
        String url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
        url = url.replace("TOKEN",AccessTokenTest.getAccessToken());
        String list = HttpClientUtil.httpsRequest(url,"POST","");
        System.out.println(list);
    }
}
