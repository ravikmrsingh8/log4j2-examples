package net.example.log4j;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class NetAppTest extends TestCase {

    public NetAppTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(NetAppTest.class);
    }

    public void testNetApp() {
        NetApp app = new NetApp();
        Assert.assertEquals("Hello World!", app.sayHello());
    }
}
