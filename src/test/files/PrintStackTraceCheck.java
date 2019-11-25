package org.slf4j;

import java.io.IOException;

class MyClass {
    int t1() {
        try {
            int i = 0;
        } catch (IOException e) {
        }
    }

    int t2() {
        try {
            int i = 0;
        } catch (IOException e) {
            int a = 1;
        }
    }

    void t3(int value) {
        try {
            int i = 0;
        } catch (IOException e) {
            e.printStackTrace(); // Noncompliant
        }
    }


    int t4() {
        try {
            int i = 0;
        } catch (IOException e) {
            int a = 1;
            int b = 1;
        }
    }

    void t5(int value) {
        try {
            int i = 0;
        } catch (IOException e) {
            e.printStackTrace(System.out); // Noncompliant
        }
    }
}

