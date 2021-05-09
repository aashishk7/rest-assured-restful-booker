package com.restbooker.api;

import com.restbooker.model.Auth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi {
    protected static final String AUTH_ENDPOINT = BASE_ENDPOINT + Version + "auth/";

    public static Response createToken(Auth payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(AUTH_ENDPOINT);
    }
}
