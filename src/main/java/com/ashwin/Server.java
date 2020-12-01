package com.ashwin;

public class Server {
    private boolean isRunning = false;

    public void start() {
        isRunning = true;
        System.out.println("Server started");
    }

    public String getOne() {
        return "1234";
    }

    public String getTwo() {
        if (isRunning) {
            return "4567";
        } else {
            throw new IllegalStateException("Server is not running");
        }
    }

    public void postOne(String body) {
        if (isRunning) {
            System.out.println("Post: " + body);
        } else {
            throw new IllegalStateException("Server is not running");
        }
    }

    public void stop() {
        isRunning = false;
        System.out.println("Server stopped");
    }
}
