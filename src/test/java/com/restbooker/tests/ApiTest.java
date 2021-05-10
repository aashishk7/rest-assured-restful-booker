package com.restbooker.tests;
import com.restbooker.RestClient.BookingApi;
import com.restbooker.RestClient.PingApi;
import com.restbooker.utils.ReusableSpecifications;
import io.qameta.allure.Description;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiTest {

    public static Integer maxSla = 5 ;

    ReusableSpecifications reusableSpecifications = new ReusableSpecifications();
    
    @DisplayName("Verifying End Point is Up or not")
    @BeforeTest
    public void verifyHealthCheck() {
        Response response = PingApi.healthCheck();
        assertThat(response.getStatusCode() == 201).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
    }
    
    @DisplayName("Creating a new booking")
    @Description("Generating a new booking and doing the basic assertions related to status code , response time and response body")
    @Test
    public void CreateBooking() {
        Response response = BookingApi.createBooking(reusableSpecifications.generateCreatePaylod());
        assertThat(response.getStatusCode() == 200).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
        assertThat(response.body().asString().isEmpty()).isFalse();
    }
    
    @DisplayName("Updating an existing booking")
    @Description("Verifying the update operation for an existing booking by updating certain details and doing assertions related to status code , response time and body")
    @Test
    public void UpdateBooking() {
        Response response = BookingApi.updateBooking(reusableSpecifications.generateCreatePaylod(), reusableSpecifications.getBookingId(), reusableSpecifications.fetchToken());
        assertThat(response.getStatusCode() == 200).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
        assertThat(response.body().asString().isEmpty()).isFalse();
    }
    
    @DisplayName("Deleting an existing booking")
    @Description("Deleting a booking after creating the same and providing token information along in the headers and verifying the basic assertions")
    @Test
    public void DeleteBooking() {
        Response response = BookingApi.deleteBooking(reusableSpecifications.getBookingId(), reusableSpecifications.fetchToken());
        assertThat(response.getStatusCode() == 201).isTrue();
        assertThat((int) response.timeIn(TimeUnit.SECONDS) <= maxSla).isTrue();
    }
}
