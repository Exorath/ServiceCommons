package com.exorath.service.commons.tableNameProvider;

/**
 * Created by toonsev on 11/3/2016.
 */
public interface TableNameProvider {
    /**
     * Gets the tableName provided by this provider
     * @return the tableName provided by this provider
     */
    String getTableName();

    /**
     * Gets a new instance of {@link TableNameProvider} that loads the tableName from a TABLE_NAME environment variable.
     * If no TABLE_NAME is provided an {@link IllegalStateException} exception will be thrown.
     * @return Environment specified {@link TableNameProvider}
     */
    static TableNameProvider getEnvironmentTableNameProvider(){
        return new EnvironmentTableNameProvider("TABLE_NAME");
    }

    /**
     * Gets a new instance of {@link TableNameProvider} that loads the tableName from the provided envVar environment variable.
     * If no environment value is provided under the envVar then an {@link IllegalStateException} exception will be thrown.
     * @return Environment specified {@link TableNameProvider}
     */
    static TableNameProvider getEnvironmentTableNameProvider(String envVar){
        return new EnvironmentTableNameProvider(envVar);
    }
}
