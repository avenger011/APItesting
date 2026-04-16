package ex2_01ResAssure;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ex2p1 {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    public void test1(){
//        RequestSpecification r;

//        Response response;
//        ValidatableResponse vr;
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

        response=r.when().post();

        String ans=response.getBody().asString();

        //System.out.println("the token retrived from api key is "+ans);
        System.out.println(ans);
        String[] ss=ans.split(":");
        String[] s1=ss[1].split("}");



        System.out.println(s1[0]);


















//        r=RestAssured.given();
//        r.baseUri("https://restful-booker.herokuapp.com");
//        r.basePath("/auth");
//        r.contentType(ContentType.JSON);
//        r.body(payload).log().all();
//
//        response=r.when().log().all().post();
//
//        vr=response.then().statusCode(200);
//        String body = response.getBody().asString();
//        System.out.println("Response Body: " + body);









    }
}
