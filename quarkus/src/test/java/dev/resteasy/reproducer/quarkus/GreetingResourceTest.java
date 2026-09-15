/*
 * Copyright The RESTEasy Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.resteasy.reproducer.quarkus;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

/**
 *
 * @author <a href="mailto:jperkins@ibm.com">James R. Perkins</a>
 */
@QuarkusTest
public class GreetingResourceTest {

    @Test
    void greeting() {
        when().get("/greeting/RESTEasy").then().statusCode(200)
                .body(equalTo("Hello RESTEasy"));
    }
}
