package com.jzt.sonar.java.checks.comment;

import com.jzt.sonar.java.checks.log.PrintStackTraceCheck;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.sonar.java.checks.verifier.JavaCheckVerifier.verify;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 14:05 <br/>
 */
@Slf4j
public class ClassMethodVarDocCheckTest {

    @Test
    public void test() {
        verify("src/test/files/ClassMethodVarDocCheck.java", new ClassMethodVarDocCheck());
    }
}
