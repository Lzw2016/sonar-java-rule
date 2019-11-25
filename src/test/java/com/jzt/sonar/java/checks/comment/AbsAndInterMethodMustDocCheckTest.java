package com.jzt.sonar.java.checks.comment;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.sonar.java.checks.verifier.JavaCheckVerifier.verify;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 14:14 <br/>
 */
@Slf4j
public class AbsAndInterMethodMustDocCheckTest {

    @Test
    public void test() {
        verify("src/test/files/AbsAndInterMethodMustDocCheck.java", new AbsAndInterMethodMustDocCheck());
    }
}
