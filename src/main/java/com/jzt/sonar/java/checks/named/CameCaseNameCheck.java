package com.jzt.sonar.java.checks.named;

import com.jzt.sonar.utils.CameCaseUtils;
import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.VariableTree;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;

/**
 * 【强制】类名、方法名、成员变量采用标准驼峰规则。类名首字母大写，方法名、成员变量首字母小写
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 09:30 <br/>
 */
@SuppressWarnings("UnstableApiUsage")
@Rule(
        key = "CameCaseNameCheck",
        name = NamedIssueMsg.IssueMsg_1,
        tags = {"custom-bug"},
        priority = Priority.CRITICAL
)
@SqaleConstantRemediation("20min")
@Slf4j
public class CameCaseNameCheck extends BaseTreeVisitor implements JavaFileScanner {
    private JavaFileScannerContext context;

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitClass(ClassTree tree) {
        String className = tree.symbol().name();
        if (!CameCaseUtils.checkUpperCameCase(className)) {
            context.reportIssue(this, tree, NamedIssueMsg.IssueMsg_1);
        }
        super.visitClass(tree);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void visitMethod(MethodTree tree) {
        // 判断是否为构造函数，构造函数返回类型为null
        if (tree.symbol().returnType() != null) {
            String methodName = tree.simpleName().name();
            if (!CameCaseUtils.checkLowerCameCase(methodName)) {
                context.reportIssue(this, tree, NamedIssueMsg.IssueMsg_1);
            }
        }
        super.visitMethod(tree);
    }

    @Override
    public void visitVariable(VariableTree tree) {
        // static / final 命名除外
        boolean isNotCheck = tree.symbol().isFinal() || tree.symbol().isStatic();
        if (!isNotCheck) {
            String variableName = tree.simpleName().name();
            if (!CameCaseUtils.checkLowerCameCase(variableName)) {
                context.reportIssue(this, tree, NamedIssueMsg.IssueMsg_1);
            }
        }
        super.visitVariable(tree);
    }
}
