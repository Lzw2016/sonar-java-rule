package com.jzt.sonar.java.checks;

import org.junit.Test;

import static org.sonar.java.checks.verifier.JavaCheckVerifier.verify;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/21 10:55 <br/>
 */
public class MyFirstCustomCheckTest {

    @Test
    public void test() {
        verify("src/test/files/MyFirstCustomCheck.java", new MyFirstCustomCheck());
    }
}
