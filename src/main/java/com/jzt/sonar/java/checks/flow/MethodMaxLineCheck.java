package com.jzt.sonar.java.checks.flow;

import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.SyntaxToken;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;

/**
 * 【强制】一个方法只做明确的一件事情，单个方法不能超过100行
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 14:25 <br/>
 */
@SuppressWarnings("UnstableApiUsage")
@Rule(
        key = "MethodMaxLineCheck",
        name = FlowIssueMsg.IssueMsg_2,
        tags = {"custom-bug"},
        priority = Priority.CRITICAL
)
@SqaleConstantRemediation("60min")
@Slf4j
public class MethodMaxLineCheck extends BaseTreeVisitor implements JavaFileScanner {
    private static final int MaxLine = 100;

    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitMethod(MethodTree tree) {
        SyntaxToken firstToken = tree.firstToken();
        SyntaxToken lastToken = tree.lastToken();
        if (firstToken != null && lastToken != null) {
            int line = lastToken.line() - firstToken.line() + 1;
            if (MaxLine < line) {
                context.reportIssue(this, tree, FlowIssueMsg.IssueMsg_2);
            }
        }
        super.visitMethod(tree);
    }
}
