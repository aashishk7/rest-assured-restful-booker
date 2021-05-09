package com.restbooker.RestClient;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PingApi extends BaseApi {
    protected static final String PING_ENDPOINT = BASE_ENDPOINT + Version + "ping/";

    @Step("Hitting Health Check request")
    public static Response healthCheck() {
        return given()
                .get(PING_ENDPOINT);
    }
}
