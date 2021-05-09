package com.restbooker.utils;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.JsonPath;
import com.restbooker.RestClient.AuthApi;
import com.restbooker.RestClient.BookingApi;
import com.restbooker.model.BookingClass;
import com.restbooker.model.BookingDatesClass;
import com.restbooker.model.Auth;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Date;

import static com.restbooker.utils.Constants.DEFAULT_PASSWORD;
import static com.restbooker.utils.Constants.DEFAULT_USER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class ReusableSpecifications {

    Faker fake = new Faker();

    @Step("Generating token from Authorization Endpoint")
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

    @Step("Generating a new Booking with some Random data")
    public Integer getBookingId()
    {
    Response bookingResponse= BookingApi.createBooking(generateCreatePaylod());
    Integer bookingId = JsonPath.read(bookingResponse.asString(), "$.bookingid");
        return bookingId ;
    }

    @Step("Generating Random Data required as body in Create and Update request")
    public BookingClass generateCreatePaylod(){
        BookingDatesClass dates = new BookingDatesClass.Builder()
                .setCheckin(new Date())
                .setCheckout(new Date())
                .build();

        BookingClass bookingpayload = new BookingClass.Builder()
                .setfirstname(fake.name().firstName())
                .setlastname(fake.name().lastName())
                .settotalprice(fake.number().numberBetween(100,1000))
                .setdepositpaid(fake.equals("true"))
                .setbookingdates(dates)
                .setadditionalneeds("Breakfast")
                .build();

        return bookingpayload ;
    }

}
