package com.ashwin;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

public class ServerRuleTest {
    @ClassRule
    public static final ServerRule resource = new ServerRule();

    @Test
    public void testServerGetOne() {
        String res = resource.getServer().getOne();
        Assert.assertEquals("testServerGetOne", "1234", res);
    }

    @Test
    public void testServerGetTwo() {
        String res = resource.getServer().getTwo();
        Assert.assertEquals("testServerGetTwo", "4567", res);
    }
}
