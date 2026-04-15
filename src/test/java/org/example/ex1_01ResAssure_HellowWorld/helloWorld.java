package org.example.ex1_01ResAssure_HellowWorld;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class helloWorld {





    @Test
    public void test_Hellow(){
        RestAssured
                .given()
                  .baseUri("https://restful-booker.herokuapp.com")
                  .basePath("/ping")
                .when()
                  .get()
                .then()
                 .statusCode(201);
    }

    @Test
    public void test_2(){
        RestAssured
                .given()
                  .baseUri("https://restful-booker.herokuapp.com")
                  .basePath("/booking")
                .when()
                  .get()
                .then()
                  .statusCode(200);


    }

    @Test
    public void test_3(){
        String id="1";
      RestAssured
              .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/"+id)
              .when()
                .get()
              .then()
                .log()
                .all()

              .statusCode(200);

    }
}
