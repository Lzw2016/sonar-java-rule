import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

class MyClass {
    private static final Logger log = LoggerFactory.getLogger("logger");

    int t5() {
        byte[] result;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            if (salt != null) {
                messageDigest.update(salt);
            }
            result = messageDigest.digest(input);
            for (int i = 1; i < iterations; i++) {
                messageDigest.reset();
                result = messageDigest.digest(result);
            }
        } catch (Throwable e) {
            throw ExceptionUtils.unchecked(e);
        }
    }

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

    public static <E> E converter(Object object, E defaultValue) {
        if (object == null) {
            return defaultValue;
        }
        try {
            return (E) object;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            return defaultValue;
        }
    }
}

