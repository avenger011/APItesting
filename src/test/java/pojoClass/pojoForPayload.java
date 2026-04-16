package pojoClass;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class pojoForPayload {
    RequestSpecification r;
    Response response;



    @Test
    public void payloadasPOJO(){
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");


        BookingDates dates = new BookingDates();
        dates.setCheckin("2018-01-01");
        dates.setCheckout("2019-01-01");

        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");

        Gson gson = new Gson();
        String jsonPayload = gson.toJson(booking);


        r.contentType(ContentType.JSON);
        r.body(jsonPayload);

        response=r.when().post();

        JsonPath jp=new JsonPath(response.asString());
        assertThat(jp.getString("booking.firstname")).isEqualToIgnoringCase("Jim");
        System.out.println(jp.getString("booking.firstname"));



    }
}
