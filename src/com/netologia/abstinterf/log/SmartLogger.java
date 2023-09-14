package com.netologia.abstinterf.log;

import java.time.LocalDateTime;

public class SmartLogger implements Logger {
    int count = 1;

    @Override
    public void log(String msg) {

        CharSequence charSequence = "error";
        String info = "INFO";
        String error = "ERROR";

        boolean contain = msg.toLowerCase().contains(charSequence);
        if (contain) {
            System.out.println(error + "#" + count + " [" + LocalDateTime.now() + "] " + msg);
        } else {
            System.out.println(info + "#" + count + " [" + LocalDateTime.now() + "] " + msg);
        }
        count++;
    }
}
