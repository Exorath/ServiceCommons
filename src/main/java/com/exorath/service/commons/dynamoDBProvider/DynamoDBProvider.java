/*
 * Copyright 2016 Exorath
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.exorath.service.commons.dynamoDBProvider;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

/**
 * Created by toonsev on 11/3/2016.
 */
public interface DynamoDBProvider {
    /**
     * Gets the providable database instance.
     * @return the providable database instance
     */
    DynamoDB getDB();

    /**
     * Loads the Database according to <a href="http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/auth/EnvironmentVariableCredentialsProvider.html">EnvironmentVariableCredentialsProvider</a>.
     * If the required AWS environment variables were not provided, an {@link IllegalStateException} will be thrown.
     * You must also provide the DynamoDB region in the AWS_REGION environment variable. If no AWS_REGION is provided an {@link IllegalStateException} exception will be thrown. If the AWS_REGION value is not an AWS Region, an {@link IllegalArgumentException} will be thrown.
     * @return a DynamoDB provider configured by the environment
     */
    static DynamoDBProvider getEnvironmentDynamoDBProvider(){
        return new EnvironmentDynamoDBProvider();
    }
}
