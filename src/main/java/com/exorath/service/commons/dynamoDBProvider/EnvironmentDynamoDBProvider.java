package com.exorath.service.commons.dynamoDBProvider;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by toonsev on 11/3/2016.
 */
public class EnvironmentDynamoDBProvider implements DynamoDBProvider {
    private static final String REGION_ENV_VAR = "AWS_REGION";
    private static final Logger LOG = LoggerFactory.getLogger(EnvironmentDynamoDBProvider.class);

    @Override
    public DynamoDB getDB() {
        try {
            AWSCredentials credentials = new EnvironmentVariableCredentialsProvider().getCredentials();
            return new DynamoDB(new AmazonDynamoDBClient(credentials).withRegion(getRegion()));
        }catch(SdkClientException e){
            throw new IllegalStateException(e);
        }
    }

    private Regions getRegion() {
        String envValue = System.getenv(REGION_ENV_VAR);
        if (envValue == null || envValue == "")
            throw new IllegalStateException("No " + REGION_ENV_VAR + " environment variable was provided while trying to load the AWS DynamoDB region");
        return Regions.valueOf(envValue);

    }
    
}
