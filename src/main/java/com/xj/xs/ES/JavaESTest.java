package com.xj.xs.ES;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */
public class JavaESTest {

    private TransportClient client;

    private IndexRequest source;

    /**
     * 获取连接, 第一种方式
     * @throws Exception
     */
    @Before
    public void before() throws Exception {
       /* Map<String, String> map = new HashMap<String, String>();
        map.put("cluster.name", "elasticsearch_wenbronk");
        Settings.Builder settings = Settings.builder().put(map);
        client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), Integer.parseInt("9300")));
        // 多久打开连接, 默认5s
        System.out.println("success connect");*/

        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch_wenbronk").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        System.out.println("success connect");
    }

   // @Before
    public void before1() throws Exception{
        // 创建客户端, 使用的默认集群名, "elasticSearch"
//        client = TransportClient.builder().build()
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("www.wenbronk.com"), 9300));

        // 通过setting对象指定集群配置信息, 配置的集群名
        Settings settings = Settings.settingsBuilder()
                //.put("cluster.name", "elasticsearch_wenbronk") // 设置集群名
              //  .put("client.transport.sniff", true) // 开启嗅探 , 开启后会一直连接不上, 原因未知
//                .put("network.host", "192.168.50.37")
            //    .put("client.transport.ignore_cluster_name", true) // 忽略集群名字验证, 打开后集群名字不对也能连接上
//                .put("client.transport.nodes_sampler_interval", 5) //报错,
//                .put("client.transport.ping_timeout", 5) // 报错, ping等待时间,
                .build();
        client = TransportClient.builder().settings(settings).build()
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9300)));
        // 默认5s
        // 多久打开连接, 默认5s
        System.out.println("success connect");
    }
    /**
     * 查看集群信息
     */
    @Test
    public void testInfo() {
        List<DiscoveryNode> nodes = client.connectedNodes();
        for (DiscoveryNode node : nodes) {
            System.out.println(node.getHostAddress());
        }
    }

    /**
     * 使用es的帮助类
     */
    public XContentBuilder createJson4() throws Exception {
        // 创建json对象, 其中一个创建json的方式
        XContentBuilder source = XContentFactory.jsonBuilder()
                .startObject()
                .field("user", "狗头")
                .field("postDate", new Date())
                .field("message", "trying to out ElasticSearch")
                .endObject();
        return source;
    }


    @Test
    public void test1() throws Exception {

        client.admin().indices().prepareCreate("twitter").get();

      /*  XContentBuilder xContentBuilder = createJson4();
        IndexResponse response = client.prepareIndex("twitter", "tweet", "10").setSource(xContentBuilder).get();
//        // 结果获取
        String index = response.getIndex();
        String type = response.getType();
        String id = response.getId();
        long version = response.getVersion();
        boolean created = response.isCreated();
        System.out.println(index + " : " + type + ": " + id + ": " + version + ": " + created);*/
    }

}
