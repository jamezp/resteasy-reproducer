/*
 * Copyright The RESTEasy Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.resteasy.reproducer.standalone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import dev.resteasy.junit.extension.annotations.RequestPath;
import dev.resteasy.junit.extension.annotations.RestBootstrap;
import dev.resteasy.junit.extension.annotations.RestResource;

/**
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
@RestBootstrap(GreetingResource.class)
class GreetingResourceTest {

    @Test
    void greet(@RestResource @RequestPath("/greeting/RESTEasy") final WebTarget target) {
        try (Response response = target.request().get()) {
            assertEquals(200, response.getStatus());
            assertEquals("Hello RESTEasy", response.readEntity(String.class));
        }
    }
}
