package com.lemon.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * Created by lemoon on 2024/6/22 08:56
 */
public class ESTest_Client {
    public static void main(String[] args) throws IOException {

        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //关闭ES客户端
        esClient.close();
    }
}
