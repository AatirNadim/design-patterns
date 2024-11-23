package design_patterns.creational;

import java.util.Date;

class Logger {
    private static Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void writeLog(Date datetime, String log) {
        System.out.println("this is a log");
    }
}