//package com.jzt.sonar.java.checks.named;
//
//import lombok.extern.slf4j.Slf4j;
//import org.sonar.check.Rule;
//import org.sonar.plugins.java.api.JavaFileScanner;
//import org.sonar.plugins.java.api.JavaFileScannerContext;
//import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
//import org.sonar.plugins.java.api.tree.ClassTree;
//import org.sonar.plugins.java.api.tree.MethodTree;
//import org.sonar.plugins.java.api.tree.VariableTree;
//
///**
// * TODO 【推荐】各种命名必须表意准确、尽可能短，除2代替‘to’，4代替‘for’外，不建议在命名中使用数字
// * <p>
// * 作者：lizw <br/>
// * 创建时间：2019/11/25 10:15 <br/>
// */
//@SuppressWarnings("UnstableApiUsage")
//@Rule(key = "SmartNameCheck")
//@Slf4j
//public class SmartNameCheck extends BaseTreeVisitor implements JavaFileScanner {
//    private JavaFileScannerContext context;
//
//    @Override
//    public void scanFile(JavaFileScannerContext context) {
//        this.context = context;
//        scan(context.getTree());
//    }
//
//    @Override
//    public void visitClass(ClassTree tree) {
//        String className = tree.symbol().name();
//
//        super.visitClass(tree);
//    }
//
//    @Override
//    public void visitMethod(MethodTree tree) {
//        tree.symbol().returnType();
//        String methodName = tree.simpleName().name();
//
//        super.visitMethod(tree);
//    }
//
//    @Override
//    public void visitVariable(VariableTree tree) {
//        // static / final 命名除外
//        String variableName = tree.simpleName().name();
//
//
//        super.visitVariable(tree);
//    }
//}
