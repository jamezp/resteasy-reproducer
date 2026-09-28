/*
 * Copyright The RESTEasy Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.resteasy.reproducer.standalone;

import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.SeBootstrap;
import jakarta.ws.rs.core.Application;

/**
 *
 * @author <a href="mailto:jperkins@ibm.com">James R. Perkins</a>
 */
@ApplicationPath("")
public class RestActivator extends Application {

    public static void main(final String... args) {
        System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");
        SeBootstrap.start(RestActivator.class)
                .toCompletableFuture().join();
    }

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(GreetingResource.class);
    }
}
