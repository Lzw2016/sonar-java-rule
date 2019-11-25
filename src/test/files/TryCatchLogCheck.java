package org.slf4j;

import java.io.IOException;

class Logger {
    public void error(String format, Object... arguments) {
    }

    public void error(String format, IOException arg) {
    }

    private static final Logger log = new Logger();

    int t1() {
        try {
            int i = 0;
        } catch (IOException e) {
            log.error("error", e);
        }
    }

    int t2() {
        try {
            int i = 0;
        } catch (IOException e) { // Noncompliant
            int a = 1;
        }
    }

    void t3(int value) {
        try {
            int i = 0;
        } catch (IOException e) { // Noncompliant
            e.printStackTrace();
        }
    }


    int t4() {
        try {
            int i = 0;
        } catch (IOException e) {
            int a = 1;
            log.error("error", e);
            int b = 1;
        }
    }
}

