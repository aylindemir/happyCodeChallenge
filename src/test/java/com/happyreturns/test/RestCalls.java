package com.happyreturns.test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.RestAssured;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestCalls {
	private final String baseuri = "https://happyreturnsqatest.free.beeceptor.com/";

    public JSONObject getVariants() {
         Response response = given()
                .baseUri(baseuri)
                .header("Content-Type", "application/json")
                .get("getProductVariants");

                assertEquals(response.statusCode(), 200);

                List variants = response.body().jsonPath().getList("variants");
                JSONObject variantsJSON = new JSONObject();
                variantsJSON.put("variants", variants);
                return  variantsJSON;
    }

    public void postOrder(Object payload) {
        Response response = given()
                .baseUri(baseuri)
                .header("Content-Type", "application/json")
                .body(payload)
                .post("order");

        assertEquals(response.statusCode(), 201);
    }
	
}
