package net.example.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetApp {
    Logger logger = LogManager.getLogger(getClass());

    public String sayHello() {
        logger.info("Hello World NetApp");
        logger.error("Hello World NetApp");
        logger.debug("Hello World NetApp");
        return "Hello World!";
    }
}
