package com.xj.xs.weixin;

import com.alibaba.fastjson.JSON;
import com.xj.xs.utils.HttpClientUtil;
import com.xj.xs.weixinmodel.AccessToken;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiong on 2018/2/5.
 */
public class SendTempletMessage {

    public static void main(String[] args) {

        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        String token = AccessTokenTest.getAccessToken();
        if(token == null || "".equals(token)){
            return;
        }
        url = url.replace("ACCESS_TOKEN",token);
        System.out.println("url:" + url);
        //https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277 文档
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("touser","ol0xIuAkOrqZ1T60jsG6GkuLKAzg");
        map.put("template_id","z8BSUvNrlt29ABIq5MFeVFz2Fi9sSoQCKC-j3Vy-8_E");
        //点击详情url
        map.put("url","http://www.taofangdd.com");
        Map<String, Object> data = packJsonmsg("您好，您已成功预约看房。","丽景华庭",
                "A栋534","广州市微信路88号","2013年10月30日 15:32","请您准时到达看房。");
        map.put("data",data);
        System.out.println(JSON.toJSONString(map));
        String message = HttpClientUtil.httpsRequest(url, "POST", JSON.toJSONString(map));
        System.out.println(message);
    }

    /**
     *
     * @param first 头部信息
     * @param apartmentName 预约楼盘
     * @param roomNumber 房号
     * @param address 地址
     * @param time 时间
     * @param remark 备注
     * @return
     */
    public static Map<String, Object> packJsonmsg(String first,String apartmentName,String roomNumber,String address,String time,String remark){

        Map<String,Object> map = new HashMap<String,Object>();

        Map<String,Object> firstMap = new HashMap<String,Object>();
        firstMap.put("value",first);
        firstMap.put("color","#173177");
        map.put("first",firstMap);

        Map<String,Object> apartmentNameMap = new HashMap<String,Object>();
        apartmentNameMap.put("value",apartmentName);
        apartmentNameMap.put("color","#173177");
        map.put("apartmentName",apartmentNameMap);

        Map<String,Object> roomNumberMap = new HashMap<String,Object>();
        roomNumberMap.put("value",roomNumber);
        roomNumberMap.put("color","#173177");
        map.put("roomNumber",roomNumberMap);

        Map<String,Object> addressMap = new HashMap<String,Object>();
        addressMap.put("value",address);
        addressMap.put("color","#173177");
        map.put("address",addressMap);

        Map<String,Object> timeMap = new HashMap<String,Object>();
        timeMap.put("value",time);
        timeMap.put("color","#173177");
        map.put("time",timeMap);

        Map<String,Object> remarkMap = new HashMap<String,Object>();
        remarkMap.put("value",remark);
        remarkMap.put("color","#173177");
        map.put("remark",remarkMap);

        return map;

    }
}
