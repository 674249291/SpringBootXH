package com.xj.xs.weixin;

import com.alibaba.fastjson.JSON;
import com.xj.xs.utils.HttpClientUtil;
import com.xj.xs.weixinmodel.AccessToken;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信获取accessToken
 * Created by xiong on 2018/2/5.
 */
public class AccessTokenTest {

    public static void main(String[] args) {
        //https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183 文档
        Map<String,String> map = new HashMap<String,String>();
        map.put("grant_type","client_credential");
        map.put("appid","wxf069663367685e6f");
        map.put("secret","2a5541522a84199d8707ca4f62d4f2e6");
        String accessToken = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token", map);
        if(accessToken == null || "".equals(accessToken)){
            return ;
        }
        System.out.println(accessToken);
        AccessToken token  = JSON.parseObject(accessToken,AccessToken.class);
        System.out.println(token.getAccessToken());
    }

    public static String getAccessToken(){
        //https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183 文档
        Map<String,String> map = new HashMap<String,String>();
        map.put("grant_type","client_credential");
        map.put("appid","wxf069663367685e6f");
        map.put("secret","2a5541522a84199d8707ca4f62d4f2e6");
        String accessToken = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token", map);
        if(accessToken == null || "".equals(accessToken)){
            return null;
        }
        AccessToken token  = JSON.parseObject(accessToken,AccessToken.class);
        return token.getAccessToken();
    }
}
