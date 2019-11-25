package com.jzt.sonar.java.checks.log;

import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;

import java.util.List;
import java.util.Set;

/**
 * 【强制】try-catch代码必须进行日志记录
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 10:24 <br/>
 */
@SuppressWarnings("UnstableApiUsage")
@Rule(
        key = "TryCatchLogCheck",
        name = LogIssueMsg.IssueMsg_1,
        tags = {"custom-bug"},
        priority = Priority.CRITICAL
)
@SqaleConstantRemediation("10min")
@Slf4j
public class TryCatchLogCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static final Set<String> LoggerClassNames = ImmutableSet.of("org.slf4j.Logger", "java.util.logging.Logger", "ch.qos.logback.classic.Logger");
    private static final Set<String> LoggerNames = ImmutableSet.of("LOGGER", "log");
    private static final String ExceptionClassName = "java.lang.Throwable";
    private static final Set<String> MethodNames = ImmutableSet.of("info", "warn", "error");

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitCatch(CatchTree tree) {
        // 是否存在类似 log.error("error msg", e) 的调用
        boolean flag = false;
        List<StatementTree> list = tree.block().body();
        for (StatementTree statementTree : list) {
            if (statementTree.is(Tree.Kind.THROW_STATEMENT)) {
                flag = true;
                break;
            }
            if (!statementTree.is(Tree.Kind.EXPRESSION_STATEMENT)) {
                continue;
            }
            ExpressionStatementTree expressionStatementTree = (ExpressionStatementTree) statementTree;
            if (!expressionStatementTree.expression().is(Tree.Kind.METHOD_INVOCATION)) {
                continue;
            }
            MethodInvocationTree methodInvocationTree = (MethodInvocationTree) expressionStatementTree.expression();
            boolean classIsLog = false;
            String typeName = methodInvocationTree.symbol().owner().type().fullyQualifiedName();
            if (typeName.equalsIgnoreCase("!unknown!") || typeName.equalsIgnoreCase("!unknownSymbol!")) {
                SyntaxToken firstToken = methodInvocationTree.firstToken();
                if (firstToken != null) {
                    String name = firstToken.text();
                    for (String loggerName : LoggerNames) {
                        if (loggerName.equalsIgnoreCase(name)) {
                            classIsLog = true;
                            break;
                        }
                    }
                }
            } else {
                for (String loggerClassName : LoggerClassNames) {
                    classIsLog = methodInvocationTree.symbol().owner().type().isSubtypeOf(loggerClassName);
                    if (classIsLog) {
                        break;
                    }
                }
            }
            if (classIsLog
                    && (StringUtils.isBlank(methodInvocationTree.symbol().name()) || MethodNames.contains(methodInvocationTree.symbol().name()))
                    && !methodInvocationTree.arguments().isEmpty()) {
                ExpressionTree arg = methodInvocationTree.arguments().get(methodInvocationTree.arguments().size() - 1);
                if (arg.symbolType().isSubtypeOf(ExceptionClassName)) {
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            context.reportIssue(this, tree, LogIssueMsg.IssueMsg_1);
        }
        super.visitCatch(tree);
    }
}
