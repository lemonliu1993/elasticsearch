package com.lemon.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * Created by lemoon on 2024/6/22 08:56
 */
public class ESTest_Client_Search {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //查询索引
        GetIndexRequest request = new GetIndexRequest("users");
        GetIndexResponse response = esClient.indices().get(request, RequestOptions.DEFAULT);

        //响应
        System.out.println(response.getAliases());
        System.out.println(response.getMappings());
        System.out.println(response.getSettings());
        esClient.close();
    }
}
