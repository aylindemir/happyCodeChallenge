package com.happyreturns.test.tests;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertEquals;
import com.happyreturns.test.RestCalls;

import java.util.*;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_Test {
	RestCalls restCalls = new RestCalls();

    @Test
    public void test1() {
        JSONObject variants = restCalls.getVariants();
        restCalls.postOrder(variants);
    }
}