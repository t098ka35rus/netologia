package com.netologia.abstinterf.log;

public class Main {
    public static void main(String[] args) {
        SimpleLogger simpleLogger = new SimpleLogger();
        SmartLogger smartLogger = new SmartLogger();
        simpleLogger.log("ПРИВЕТ");
        smartLogger.log("error есть");
        smartLogger.log("ошибки нет");
        smartLogger.log("просто сообщение");
        smartLogger.log("просто error13");

    }

}
