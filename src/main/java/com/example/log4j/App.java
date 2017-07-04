package com.example.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    Logger logger = LogManager.getLogger(getClass());

    public String sayHello() {
        logger.error("Hello World App");
        return "Hello World!";
    }
}
