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

package com.exorath.service.commons.portProvider;

/**
 * Created by toonsev on 11/3/2016.
 */
public interface PortProvider {
    /**
     * Gets the port to open a service on
     * @return the port to open a service on
     */
    int getPort();

    /**
     * Gets a new instance of the port provider that loads the port from a PORT environment variable.
     * If no env value is provided an {@link IllegalStateException will be thrown}. If the env var is not a number an {@link NumberFormatException} will be thrown.
     * @return Environment specified port provider
     */
    static PortProvider getEnvironmentPortProvider(){
        return new EnvironmentPortProvider("PORT");
    }

    /**
     * Gets a new instance of the port provider that loads the port from the specified environment variable.
     * If no env value is provided an {@link IllegalStateException will be thrown}. If the env var is not a number an {@link NumberFormatException} will be thrown.
     * @param envVar environment variable to load port from
     * @return Environment specified port provider
     */
    static PortProvider getEnvironmentPortProvider(String envVar){
        return new EnvironmentPortProvider(envVar);
    }
}
