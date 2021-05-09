package com.restbooker.tests;
import com.restbooker.api.BookingApi;
import com.restbooker.api.PingApi;
import com.restbooker.utils.ReusableSpecifications;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiTest {

    ReusableSpecifications reusableSpecifications = new ReusableSpecifications();

    @BeforeTest
    public void verifyHealthCheck() {
        Response response = PingApi.healthCheck();
        assertThat(response.getStatusCode() == 201).isTrue();
    }

    @Test
    public void CreateBooking() {
        Response response = BookingApi.createBooking(reusableSpecifications.generateCreatePaylod());
        assertThat(response.getStatusCode() == 200).isTrue();
    }

    @Test
    public void UpdateBooking() {
        Response response = BookingApi.updateBooking(reusableSpecifications.generateCreatePaylod(), reusableSpecifications.getBookingId() , reusableSpecifications.fetchToken());
        assertThat(response.getStatusCode() == 200).isTrue();
    }
    
    @Test
    public void DeleteBooking() {
        Response response = BookingApi.deleteBooking(reusableSpecifications.getBookingId(), reusableSpecifications.fetchToken());
        assertThat(response.getStatusCode() == 201).isTrue();
    }
}
