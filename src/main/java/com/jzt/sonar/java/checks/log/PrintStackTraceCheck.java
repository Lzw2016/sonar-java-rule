package com.jzt.sonar.java.checks.log;

import com.google.common.collect.ImmutableList;
import com.jzt.sonar.java.checks.AbstractMethodDetection;
import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.java.matcher.MethodMatcher;
import org.sonar.java.matcher.NameCriteria;
import org.sonar.java.matcher.TypeCriteria;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;

import java.util.List;

/**
 * 【强制】禁止使用e.printStackTrace()
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 13:33 <br/>
 */
@SuppressWarnings("UnstableApiUsage")
@Rule(
        key = "PrintStackTraceCheck",
        name = LogIssueMsg.IssueMsg_2,
        tags = {"custom-bug"},
        priority = Priority.CRITICAL
)
@SqaleConstantRemediation("10min")
@Slf4j
public class PrintStackTraceCheck extends AbstractMethodDetection {

    @Override
    protected List<MethodMatcher> getMethodInvocationMatchers() {
        return ImmutableList.of(
                MethodMatcher.create()
                        .typeDefinition("java.lang.Throwable")
                        .name(NameCriteria.is("printStackTrace"))
                        .addParameter(TypeCriteria.anyType()),
                MethodMatcher.create()
                        .typeDefinition("java.lang.Throwable")
                        .name(NameCriteria.is("printStackTrace"))
                        .withoutParameter()
        );
    }

    @Override
    protected void onMethodInvocationFound(MethodInvocationTree mit) {
        context.reportIssue(this, mit, LogIssueMsg.IssueMsg_2);
    }
}
