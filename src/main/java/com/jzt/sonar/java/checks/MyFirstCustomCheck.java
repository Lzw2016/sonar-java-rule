package com.jzt.sonar.java.checks;

import lombok.extern.slf4j.Slf4j;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

import static org.sonar.plugins.java.api.tree.Tree.Kind;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/21 10:57 <br/>
 */
@Rule(
        key = "MyFirstCustomCheck",
        name = "方法的返回类型和参数不应该相同",
        description = "对于具有单个参数的方法，其返回值和参数的类型不应该相同",
        priority = Priority.CRITICAL,
        tags = {"bug"}
)
@Slf4j
public class MyFirstCustomCheck extends IssuableSubscriptionVisitor {

    @Override
    public List<Kind> nodesToVisit() {
        return Collections.singletonList(Kind.METHOD);
    }

    @Override
    public void visitNode(Tree tree) {
        if (!tree.is(Kind.METHOD)) {
            return;
        }
        MethodTree method = (MethodTree) tree;
        log.info("## [{}] - {}", method.simpleName(), method.parameters().size());
        if (method.parameters().size() == 1) {
            Symbol.MethodSymbol symbol = method.symbol();
            Type firstParameterType = symbol.parameterTypes().get(0);
            Type returnType = symbol.returnType().type();
            if (returnType.is(firstParameterType.fullyQualifiedName())) {
                reportIssue(method.simpleName(), "Never do that!");
            }
        }
    }
}
