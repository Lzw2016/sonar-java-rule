package com.jzt.sonar.java;

import com.jzt.sonar.java.checks.comment.AbsAndInterMethodMustDocCheck;
import com.jzt.sonar.java.checks.comment.ClassMethodVarDocCheck;
import com.jzt.sonar.java.checks.flow.MethodMaxLineCheck;
import com.jzt.sonar.java.checks.log.PrintStackTraceCheck;
import com.jzt.sonar.java.checks.log.TryCatchLogCheck;
import com.jzt.sonar.java.checks.named.CameCaseNameCheck;
import com.jzt.sonar.java.checks.named.FinalVariableNameCheck;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class RulesList {

    private RulesList() {
    }

    public static List<Class<? extends JavaCheck>> getChecks() {
        List<Class<? extends JavaCheck>> checks = new ArrayList<>();
        checks.addAll(getJavaChecks());
        checks.addAll(getJavaTestChecks());
        return Collections.unmodifiableList(checks);
    }

    static List<Class<? extends JavaCheck>> getJavaChecks() {
        return Collections.unmodifiableList(
                Arrays.asList(
                        AbsAndInterMethodMustDocCheck.class,
                        ClassMethodVarDocCheck.class,

                        MethodMaxLineCheck.class,

                        PrintStackTraceCheck.class,
                        TryCatchLogCheck.class,

                        CameCaseNameCheck.class,
                        FinalVariableNameCheck.class
                )
        );
    }

    static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return Collections.emptyList();
    }
}
