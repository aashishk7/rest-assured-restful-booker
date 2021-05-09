package com.restbooker.api;

import com.restbooker.model.BookingClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi extends BaseApi {

    protected static final String BOOKING_ENDPOINT = BASE_ENDPOINT + Version + "booking";

    public static Response createBooking(BookingClass bookingPayload) {
        System.out.println(BOOKING_ENDPOINT);
        return given()
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .when()
                .post(BOOKING_ENDPOINT);
    }

    public static Response updateBooking(BookingClass bookingPayload , int id , String token) {
        System.out.println(BOOKING_ENDPOINT+"/"+Integer.toString(id));
        return given()
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .header("Cookie", "token=" + token)
                .when()
                .put(BOOKING_ENDPOINT+"/"+Integer.toString(id));
    }

    public static Response deleteBooking(int id, String token) {
        System.out.println(BOOKING_ENDPOINT+"/"+Integer.toString(id));
        System.out.println(token);
        return given()
                .header("Cookie", "token=" + token)
                .delete(BOOKING_ENDPOINT +"/"+ Integer.toString(id));
    }
}
