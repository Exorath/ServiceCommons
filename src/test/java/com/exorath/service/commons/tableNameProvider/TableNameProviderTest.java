package com.exorath.service.commons.tableNameProvider;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.junit.Assert.assertEquals;

/**
 * Created by toonsev on 11/3/2016.
 */
public class TableNameProviderTest {
    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test(expected = IllegalStateException.class)
    public void getTableNameThrowsIllegalStateExceptionByDefaultTest() {
        TableNameProvider.getEnvironmentTableNameProvider().getTableName();
    }

    @Test
    public void getTableNameWithDefinedTABLE_NAMEEnvVarReturnsValueTest() {
        environmentVariables.set("TABLE_NAME", "ThisIsTable");
        String actual = TableNameProvider.getEnvironmentTableNameProvider().getTableName();
        assertEquals("ThisIsTable", actual);
    }

    @Test
    public void getPortWithDefinedCustomEnvVarReturnsValueTest() {
        environmentVariables.set("CUSTOM_TABLE", "ThisIsAlsoTable");
        String actual = TableNameProvider.getEnvironmentTableNameProvider("CUSTOM_TABLE").getTableName();
        assertEquals("ThisIsAlsoTable", actual);
    }

}
