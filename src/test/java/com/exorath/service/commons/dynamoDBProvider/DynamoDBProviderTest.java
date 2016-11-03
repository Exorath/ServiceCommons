package com.exorath.service.commons.dynamoDBProvider;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.exorath.service.commons.tableNameProvider.TableNameProvider;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.junit.Assert.assertEquals;

/**
 * Created by toonsev on 11/3/2016.
 */
public class DynamoDBProviderTest {
    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test(expected = IllegalStateException.class)
    public void getEnvironmentDynamoDBProviderGetDBThrowsIllegalStateExByDefaultTest() {
        DynamoDBProvider.getEnvironmentDynamoDBProvider().getDB();
    }

    @Test(expected = IllegalStateException.class)
    public void getEnvironmentDynamoDBProviderGetDBThrowsIllegalStateExWhenDefaultRegionEnvNotProvidedTest() {
        environmentVariables.set("AWS_ACCESS_KEY", "asd");
        environmentVariables.set("AWS_SECRET_ACCESS_KEY", "asd");
        DynamoDB actual = DynamoDBProvider.getEnvironmentDynamoDBProvider().getDB();
        assertEquals("ThisIsTable", actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getEnvironmentDynamoDBProviderGetDBThrowsIllegalArgumentExWhenRegionEnvProvidedButNotRealRegionTest() {
        environmentVariables.set("AWS_ACCESS_KEY", "asd");
        environmentVariables.set("AWS_SECRET_ACCESS_KEY", "asd");
        environmentVariables.set("AWS_REGION", "blah");
        DynamoDB actual = DynamoDBProvider.getEnvironmentDynamoDBProvider().getDB();
        assertEquals("ThisIsTable", actual);
    }
    @Test
    public void getEnvironmentDynamoDBProviderGetDBRegionDoesNotThrowExceptionTest() {
        environmentVariables.set("AWS_ACCESS_KEY", "asd");
        environmentVariables.set("AWS_SECRET_ACCESS_KEY", "asd");
        environmentVariables.set("AWS_REGION", Regions.EU_WEST_1.toString());
        DynamoDB db = DynamoDBProvider.getEnvironmentDynamoDBProvider().getDB();
    }
}
