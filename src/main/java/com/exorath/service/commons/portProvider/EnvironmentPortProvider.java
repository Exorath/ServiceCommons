package com.exorath.service.commons.portProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by toonsev on 11/3/2016.
 */
public class EnvironmentPortProvider implements PortProvider {
    private static final Logger LOG = LoggerFactory.getLogger(PortProvider.class);
    private String envVar;

    public EnvironmentPortProvider(String envVar) {
        this.envVar = envVar;

    }

    @Override
    public int getPort() {
        String envValue = System.getenv(envVar);
        if (envValue == null || envValue == "")
            throw new IllegalStateException("No " + envVar + " environment variable was provided while trying to load the port.");
        return Integer.parseInt(System.getenv(envVar));

    }
}
