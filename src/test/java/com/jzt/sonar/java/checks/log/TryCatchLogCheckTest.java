package com.jzt.sonar.java.checks.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.sonar.java.checks.verifier.JavaCheckVerifier.verify;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 11:09 <br/>
 */
@Slf4j
public class TryCatchLogCheckTest {

    @Test
    public void test() {
        verify("src/test/files/TryCatchLogCheck.java", new TryCatchLogCheck());
    }
}
