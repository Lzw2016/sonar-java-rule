package com.jzt.sonar.java.checks.named;

import com.jzt.sonar.utils.CameCaseUtils;
import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.VariableTree;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;

/**
 * 【强制】终态变量命名采用全大写以下划线分割
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 10:05 <br/>
 */
@SuppressWarnings("UnstableApiUsage")
@Rule(
        key = "FinalVariableNameCheck",
        name = NamedIssueMsg.IssueMsg_2,
        tags = {"custom-bug"},
        priority = Priority.CRITICAL
)
@SqaleConstantRemediation("10min")
@Slf4j
public class FinalVariableNameCheck extends BaseTreeVisitor implements JavaFileScanner {
    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitVariable(VariableTree tree) {
        boolean isNotCheck = tree.symbol().isStatic();
        if (isNotCheck) {
            String variableName = tree.simpleName().name();
            if (!CameCaseUtils.checkAllUpper(variableName)) {
                context.reportIssue(this, tree, NamedIssueMsg.IssueMsg_2);
            }
        }
        super.visitVariable(tree);
    }
}
