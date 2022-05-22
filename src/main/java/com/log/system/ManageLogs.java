package com.log.system;

import java.io.IOException;
import java.util.logging.*;

public class ManageLogs {

    public static void main(String[] args) throws IOException {
//        logs();
        playWithLogs();
        fileHandler();
    }

    static public void logs() {
        LogManager lm = LogManager.getLogManager();
        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO, "Test log message");
        logger.log(Level.INFO, "Test second message");
    }

    static public void playWithLogs() {
        LogManager lm = LogManager.getLogManager();
        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
//        logger.setLevel(Level.OFF);
        logger.setLevel(Level.ALL);
        logger.log(Level.SEVERE, "Severe message");
        logger.log(Level.INFO, "Info message");
        logger.log(Level.INFO, "{0} is my favourite {1}", new Object[]{"Java", "language"});
        logger.log(Level.FINE, "Fine message");
        logger.fine("Fine now");
        logger.exiting("com.log.system.ManageLogs", "Exiting now");
    }

    static public void logHandler() {
        Logger logger = Logger.getLogger("com.log.system");
        Handler handler = new ConsoleHandler();
        Formatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger.addHandler(handler);
        logger.setLevel(Level.INFO);
    }

    static public void fileHandler() throws IOException {
        Logger logger = Logger.getLogger("com.log.system");
        FileHandler handler = new FileHandler("%h/myapp_%g.log", 1000, 4);
        logger.addHandler(handler);
    }
}
