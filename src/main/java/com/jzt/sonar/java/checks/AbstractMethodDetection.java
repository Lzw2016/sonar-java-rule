package com.jzt.sonar.java.checks;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.sonar.java.matcher.MethodMatcher;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;
import org.sonar.plugins.java.api.tree.NewClassTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.List;

/**
 * 方法调用检查
 *
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 11:46 <br/>
 */
@SuppressWarnings("UnstableApiUsage")
@Slf4j
public abstract class AbstractMethodDetection extends IssuableSubscriptionVisitor {
    private List<MethodMatcher> matchers;

    /**
     * 筛选方法调用和新class声明
     */
    @Override
    public List<Tree.Kind> nodesToVisit() {
        return ImmutableList.of(Tree.Kind.METHOD_INVOCATION, Tree.Kind.NEW_CLASS);
    }

    @Override
    public void visitNode(Tree tree) {
        if (hasSemantic()) {
            for (MethodMatcher invocationMatcher : matchers()) {
                checkInvocation(tree, invocationMatcher);
            }
        }
    }

    private List<MethodMatcher> matchers() {
        if (matchers == null) {
            matchers = getMethodInvocationMatchers();
        }
        return matchers;
    }

    /**
     * 检查方法调用
     */
    private void checkInvocation(Tree tree, MethodMatcher invocationMatcher) {
        if (tree.is(Tree.Kind.METHOD_INVOCATION)) {
            MethodInvocationTree mit = (MethodInvocationTree) tree;
            if (invocationMatcher.matches(mit)) {
                onMethodInvocationFound(mit);
            }
        } else if (tree.is(Tree.Kind.NEW_CLASS)) {
            NewClassTree newClassTree = (NewClassTree) tree;
            if (invocationMatcher.matches(newClassTree)) {
                onConstructorFound(newClassTree);
            }
        }
    }

    protected abstract List<MethodMatcher> getMethodInvocationMatchers();

    /**
     * 校验方法调用
     */
    protected void onMethodInvocationFound(MethodInvocationTree mit) {
        // Do nothing by default
    }

    /**
     * 校验构造函数
     */
    protected void onConstructorFound(NewClassTree newClassTree) {
        // Do nothing by default
    }
}
