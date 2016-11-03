package com.exorath.service.commons.portProvider;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.junit.Assert.assertEquals;

/**
 * Created by toonsev on 11/3/2016.
 */
public class PortProviderTest {
    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test(expected = IllegalStateException.class)
    public void getPortThrowsIllegalStateExceptionByDefaultTest(){
        PortProvider.getEnvironmentPortProvider().getPort();
    }
    @Test
    public void getPortWithDefinedPORTEnvVarReturnsValueTest(){
        environmentVariables.set("PORT", "1234");
        int actual = PortProvider.getEnvironmentPortProvider().getPort();
        assertEquals(1234, actual);
    }
    @Test
    public void getPortWithDefinedCustomEnvVarReturnsValueTest(){
        environmentVariables.set("CUSTOM_PORT", "1234");
        int actual = PortProvider.getEnvironmentPortProvider("CUSTOM_PORT").getPort();
        assertEquals(1234, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void getPortWithMissformedEnvVarThrowsNumberFormatExceptionTest(){
        environmentVariables.set("PORT", "abc");
        PortProvider.getEnvironmentPortProvider().getPort();
    }
}
