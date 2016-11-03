package com.exorath.service.commons.tableNameProvider;


/**
 * Created by toonsev on 11/3/2016.
 */
public class EnvironmentTableNameProvider implements TableNameProvider{
    private String envVar;
    public EnvironmentTableNameProvider(String envVar){
        this.envVar = envVar;
    }

    @Override
    public String getTableName() {
        String envValue = System.getenv(envVar);
        if(envValue == null || envValue == "")
            throw new IllegalStateException("No " + envVar + " environment variable was provided while trying to load the tableName");
        return envValue;
    }
}
