package ex2_01ResAssure;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.testng.annotations.Test;

public class exp2try {
   RequestSpecification r;
   Response response;

    @Test
    public void test1(){
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        String url="https://restful-booker.herokuapp.com";
        String bp="/auth";

        r= RestAssured.given();
        r.baseUri(url);
        r.basePath(bp);
        r.contentType(ContentType.JSON);
        r.body(payload);

        response=r.when().post();

        String anss=response.getBody().asString();
        System.out.println(anss);




    }


















}
