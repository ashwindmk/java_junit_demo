package com.ashwin;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class ServerTest {
    private static final Server server = new Server();

    @ClassRule
    public static final ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            server.start();
        }

        @Override
        protected void after() {
            server.stop();
        }
    };

    @Test
    public void testServerGetOne() {
        String res = server.getOne();
        Assert.assertEquals("testServerGetOne", "1234", res);
    }

    @Test
    public void testServerGetTwo() {
        String res = server.getTwo();
        Assert.assertEquals("testServerGetTwo", "4567", res);
    }
}
