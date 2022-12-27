package com.restful.booker.crudtest;


import com.restful.booker.model.CreatePojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostBookingTest extends TestBase {


    @Test
    public void createBookingData(){
        HashMap<Object, Object> bookingsDatesData = new HashMap<>();
        bookingsDatesData.put("checkin", "2022-12-28");
        bookingsDatesData.put("checkout", "2023-01-01");


        CreatePojo createPojo =new CreatePojo();
        createPojo.setFirstname("Raja");
        createPojo.setLastname("RamSita");
        createPojo.setTotalprice(2858);
        createPojo.setDepositpaid(true);
        createPojo.setBookingdates(bookingsDatesData);

        createPojo.setAdditionalneeds("Breakfast");

        Response response=given()
                .header("Cookie", "token=7d2560157cb4343")
                .header("Content-Type", "application/json")
                .body(createPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
