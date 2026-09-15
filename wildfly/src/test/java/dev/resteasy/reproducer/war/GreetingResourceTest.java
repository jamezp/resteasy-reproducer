/*
 * Copyright The RESTEasy Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.resteasy.reproducer.war;

import java.net.URI;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.Response;

import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wildfly.testing.junit.extension.annotation.GenerateDeployment;
import org.wildfly.testing.junit.extension.annotation.RequestPath;
import org.wildfly.testing.junit.extension.annotation.ServerResource;
import org.wildfly.testing.junit.extension.annotation.WildFlyTest;

/**
 *
 * @author <a href="mailto:jperkins@ibm.com">James R. Perkins</a>
 */
@WildFlyTest
public class GreetingResourceTest {

    @ServerResource
    @RequestPath("/api/greeting/RESTEasy")
    private URI uri;

    @GenerateDeployment
    public static void deployment(final WebArchive war) {
        war.addClasses(GreetingResource.class, RestActivator.class);
    }

    @Test
    public void checkResponse(@ServerResource final Client client) {
        try (Response response = client.target(uri).request().get()) {
            final String body = response.readEntity(String.class);
            Assertions.assertEquals(200, response.getStatus(),
                    () -> "Expected HTTP status code %d: %s".formatted(response.getStatus(), body));
            Assertions.assertEquals("Hello RESTEasy", body,
                    () -> "Expected response 'Hello RESTEasy', but was: %s".formatted(body));
        }
    }
}
