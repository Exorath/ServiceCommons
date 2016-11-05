package com.exorath.service.commons.postgreSQLProvider;

import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.net.URI;

/**
 * Seems like this may not be the way to do stuff: https://jdbc.postgresql.org/documentation/publicapi/org/postgresql/ds/PGPoolingDataSource.html, requires testing
 * Created by toonsev on 11/4/2016.
 */
public class EnvironmentPGProvider implements PGProvider{
    private String uriEnvName;
    private String maxConnectionsEnvName;
    public EnvironmentPGProvider(String uriEnvName, String maxConnectionsEnvName){
        this.uriEnvName = uriEnvName;
        this.maxConnectionsEnvName = maxConnectionsEnvName;
    }

    @Override
    public DataSource getDataSource() {
        URI uri = getURIFromEnv();
        String host = uri.getHost();
        int port = uri.getPort();
        String db = uri.getPath().substring(1);
        String username = uri.getUserInfo().split(":")[0];
        String password = uri.getUserInfo().split(":")[1];

        PGPoolingDataSource ds = new PGPoolingDataSource();
        ds.setSsl(true);
        ds.setSslMode("verify-full");
        ds.setUser(username);
        ds.setServerName(host);
        ds.setPortNumber(port);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setInitialConnections(0);
        Integer maxConnections = getMaxConnectionsFromEnv();
        if(maxConnections != null)
            ds.setMaxConnections(maxConnections);
        return ds;
    }

    private URI getURIFromEnv(){
        String envValue = System.getenv(uriEnvName);
        if(envValue == null || envValue == "")
            throw new IllegalStateException("No " + uriEnvName + " environment variable was provided while trying to load the tableName");
        return URI.create(envValue);
    }
    private Integer getMaxConnectionsFromEnv(){
        String envValue = System.getenv(maxConnectionsEnvName);
        if(envValue == null || envValue == "")
            return null;
        Integer maxConnections =  Integer.valueOf(envValue);
        if(maxConnections <= 0)
            throw new IllegalStateException("Failed to load max connections from environment variable: " + maxConnectionsEnvName + ". Value must be greater then 0.");
        return maxConnections;
    }
}
