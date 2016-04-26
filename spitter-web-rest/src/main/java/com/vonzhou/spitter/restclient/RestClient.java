package com.vonzhou.spitter.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vonzhou.spitter.persistence.Spittle;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

/**
 * Created by vonzhou on 16/4/25.
 */
public class RestClient {

    public Spittle[] retrieveSpittleForSpitter(String username) {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            // 服务器端没有设置处理json,也能正确处理
            String spittleUrl = "http://localhost:8080/Spitter/spitters/" + username + "/spittles";

            HttpGet getRequest = new HttpGet(spittleUrl);
            getRequest.setHeader(new BasicHeader("Accept", "application/json"));

            HttpResponse response = httpClient.execute(getRequest);

            HttpEntity entity = response.getEntity();

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(entity.getContent(), Spittle[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        Spittle[] list = new RestClient().retrieveSpittleForSpitter("chown2");
        for(int i=0;i < list.length; i++){
            System.out.println(list[0]);
        }

    }


}
