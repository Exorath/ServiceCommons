package com.exorath.service.commons.postgreSQLProvider;


import javax.sql.DataSource;

/**
 * Created by toonsev on 11/4/2016.
 */
public interface PGProvider {
     DataSource getDataSource();
}
