package com.lemon.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * Created by lemoon on 2024/6/22 08:56
 */
public class ESTest_Client_Create {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //创建索引
        CreateIndexRequest request = new CreateIndexRequest("users");
        CreateIndexResponse response = esClient.indices().create(request, RequestOptions.DEFAULT);

        //响应状态
        boolean acknowledged = response.isAcknowledged();
        System.out.println("索引操作 :" + acknowledged);
        esClient.close();
    }
}
