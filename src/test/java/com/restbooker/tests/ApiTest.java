package com.restbooker.tests;
import com.restbooker.RestClient.BookingApi;
import com.restbooker.RestClient.PingApi;
import com.restbooker.utils.ReusableSpecifications;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;

public class ApiTest {

    public static Integer maxSla = 5 ;

    ReusableSpecifications reusableSpecifications = new ReusableSpecifications();

    @BeforeTest
    public void verifyHealthCheck() {
        Response response = PingApi.healthCheck();
        assertThat(response.getStatusCode() == 201).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
    }

    @Test
    public void CreateBooking() {
        Response response = BookingApi.createBooking(reusableSpecifications.generateCreatePaylod());
        assertThat(response.getStatusCode() == 200).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
        assertThat(response.body().asString().isEmpty()).isFalse();
    }

    @Test
    public void UpdateBooking() {
        Response response = BookingApi.updateBooking(reusableSpecifications.generateCreatePaylod(), reusableSpecifications.getBookingId(), reusableSpecifications.fetchToken());
        assertThat(response.getStatusCode() == 200).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
        assertThat(response.body().asString().isEmpty()).isFalse();
    }

    @Test
    public void DeleteBooking() {
        Response response = BookingApi.deleteBooking(reusableSpecifications.getBookingId(), reusableSpecifications.fetchToken());
        assertThat(response.getStatusCode() == 201).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
    }
}
