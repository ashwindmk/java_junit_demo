package com.ashwin;

import org.junit.rules.ExternalResource;

public class ServerRule extends ExternalResource {
    private static final Server server = new Server();

    @Override
    protected void before() throws Throwable {
        server.start();
    }

    @Override
    protected void after() {
        server.stop();
    }

    public Server getServer() {
        return server;
    }
}
