package com.jzt.sonar.java.checks.comment;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

/**
 * 【强制】类、类属性、类方法的注释必须使用javadoc规范
 * <p>
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 13:33 <br/>
 */
@SuppressWarnings("UnstableApiUsage")
@Rule(key = "ClassMethodVarDocCheck")
@Slf4j
public class ClassMethodVarDocCheck extends BaseTreeVisitor implements JavaFileScanner {
    private JavaFileScannerContext context;

    private static final String ISSUE_MSG = "类、类属性、类方法的注释必须使用javadoc规范,使用“/** ... */”格式,不得使用“// ...”方式和“/* ... */”方式";

    @Override
    public void scanFile(JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitClass(ClassTree tree) {
        String classJavadoc = getJavadoc(tree.modifiers().firstToken());
        reportJavaDocIssue(classJavadoc, tree);
        super.visitClass(tree);
    }

    @Override
    public void visitMethod(MethodTree tree) {
        String classJavadoc = getJavadoc(tree.modifiers().firstToken());
        reportJavaDocIssue(classJavadoc, tree);
        super.visitMethod(tree);
    }

    @Override
    public void visitVariable(VariableTree tree) {
        if (tree.symbol().isPublic() || tree.symbol().isProtected() || tree.symbol().isPrivate()) {
            String classJavadoc = getJavadoc(tree.modifiers().firstToken());
            reportJavaDocIssue(classJavadoc, tree);
        }
        super.visitVariable(tree);
    }

    /**
     * 获取类注释 注意:不考虑没有注释的情况 详情可见 ClassMustHaveAuthorCheck 这里要求必须要有注释
     */
    private String getJavadoc(SyntaxToken firstToken) {
        if (firstToken == null) {
            return null;
        }
        String javadoc = null;
        if (!firstToken.trivias().isEmpty()) {
            for (SyntaxTrivia trivia : firstToken.trivias()) {
                javadoc = trivia.comment();
            }
        }
        return javadoc;
    }

    private void reportJavaDocIssue(String classJavadoc, Tree tree) {
        if (classJavadoc == null) {
            classJavadoc = StringUtils.EMPTY;
        }
        if (!classJavadoc.trim().startsWith("/**")) {
            context.reportIssue(this, tree, ISSUE_MSG);
        }
    }
}
