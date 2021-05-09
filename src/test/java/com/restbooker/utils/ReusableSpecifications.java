package com.restbooker.utils;

import com.jayway.jsonpath.JsonPath;
import com.restbooker.api.AuthApi;
import com.restbooker.api.BookingApi;
import com.restbooker.model.BookingClass;
import com.restbooker.model.BookingDatesClass;
import com.restbooker.model.Auth;
import io.restassured.response.Response;

import java.util.Date;

import static com.restbooker.utils.Constants.DEFAULT_PASSWORD;
import static com.restbooker.utils.Constants.DEFAULT_USER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class ReusableSpecifications {

    public String fetchToken() {

        Auth auth = new Auth.Builder()
                .setusername(DEFAULT_USER_NAME)
                .setpassword(DEFAULT_PASSWORD)
                .build();

        Response authResponse = AuthApi.createToken(auth);
        assertThat(authResponse.getStatusCode() == 200).isTrue();
        String token = JsonPath.read(authResponse.asString(), "$.token");
        System.out.println(token);
        return token ;
    }

    public Integer getBookingId(){

    BookingDatesClass dates = new BookingDatesClass.Builder()
            .setCheckin(new Date())
            .setCheckout(new Date())
            .build();

    BookingClass bookingpayload = new BookingClass.Builder()
            .setfirstname("Jim")
            .setlastname("Brown")
            .settotalprice(200)
            .setdepositpaid(true)
            .setbookingdates(dates)
            .setadditionalneeds("Breakfast")
            .build();

        System.out.println(("BOOKING FETCHED"));

    Response bookingResponse= BookingApi.createBooking(bookingpayload);
    Integer bookingId = JsonPath.read(bookingResponse.asString(), "$.bookingid");
        System.out.println(bookingId);
        return bookingId ;
    }

    public BookingClass generateCreatePaylod(){
        BookingDatesClass dates = new BookingDatesClass.Builder()
                .setCheckin(new Date())
                .setCheckout(new Date())
                .build();

        BookingClass bookingpayload = new BookingClass.Builder()
                .setfirstname("Jim")
                .setlastname("Brown")
                .settotalprice(200)
                .setdepositpaid(true)
                .setbookingdates(dates)
                .setadditionalneeds("Breakfast")
                .build();

        return bookingpayload ;
    }

}