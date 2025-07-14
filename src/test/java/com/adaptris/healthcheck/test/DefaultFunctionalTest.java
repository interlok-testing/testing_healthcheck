package com.adaptris.healthcheck.test;

import com.adaptris.testing.SingleAdapterFunctionalTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class DefaultFunctionalTest extends SingleAdapterFunctionalTest {

    @Test
    public void testHealthCheckWithSuccess() throws Exception {
        get(getBaseAdapterUrl() + "/api/success")
                .then().body("status", equalTo("ok")).and().statusCode(200);
    }

    @Test
    public void testHealthCheckWithFailure() throws Exception {
        get(getBaseAdapterUrl()+"/api/fail").then().statusCode(500);
    }
}
