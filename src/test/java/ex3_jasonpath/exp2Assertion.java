package ex3_jasonpath;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class exp2Assertion {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void testAssertion(){
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2");
        response=r.when().get();

//        JsonPath jp=new JsonPath(response.asString());
//        assertThat(jp.getInt("totalprice")).isEqualTo(246);

        JsonPath jp=new JsonPath(response.asString());
        String name= jp.getString("firstname");
        System.out.println("name was "+name);
        assertThat(name).isEqualToIgnoringCase("Sally");
        assertThat(jp.getInt("totalprice")).isBetween(0,700);
        System.out.println("the amount was "+jp.getInt("totalprice"));





    }
}
