package com.restbooker.RestClient;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PingApi extends BaseApi {
    protected static final String PING_ENDPOINT = BASE_ENDPOINT + Version + "ping/";

    public static Response healthCheck() {
        System.out.println(PING_ENDPOINT);
        return given()
                .get(PING_ENDPOINT);
    }
}
