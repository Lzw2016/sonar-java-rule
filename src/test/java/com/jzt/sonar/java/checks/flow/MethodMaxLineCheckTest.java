package com.jzt.sonar.java.checks.flow;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.sonar.java.checks.verifier.JavaCheckVerifier.verify;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 14:29 <br/>
 */
@Slf4j
public class MethodMaxLineCheckTest {

    @Test
    public void test() {
        verify("src/test/files/MethodMaxLineCheck.java", new MethodMaxLineCheck());
    }
}
