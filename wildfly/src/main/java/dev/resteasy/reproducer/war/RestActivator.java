/*
 * Copyright The RESTEasy Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package dev.resteasy.reproducer.war;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Activates JAX-RS and defines the application base path.
 */
@ApplicationPath("/api")
public class RestActivator extends Application {
}
