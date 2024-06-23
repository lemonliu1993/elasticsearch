package com.lemon.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * Created by lemoon on 2024/6/22 08:56
 */
public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //插入数据
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("users").id("1001").source(XContentType.JSON, "name", "zhangsan"));
        request.add(new IndexRequest().index("users").id("1002").source(XContentType.JSON, "name", "lisi"));
        request.add(new IndexRequest().index("users").id("1003").source(XContentType.JSON, "name", "wangwu"));

        //向ES插入数据，必须将数据转换为JSON格式
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());

        //响应状态
        esClient.close();
    }
}
