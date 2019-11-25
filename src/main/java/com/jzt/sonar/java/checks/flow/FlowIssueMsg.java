package com.jzt.sonar.java.checks.flow;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 10:27 <br/>
 */
interface FlowIssueMsg {
    String IssueMsg_1 = "【强制】controller用于参数、返回值的验证及封装，service用于业务逻辑的封装";
    String IssueMsg_2 = "【强制】一个方法只做明确的一件事情，单个方法不能超过100行";
    String IssueMsg_3 = "【强制】代码中需要用到的数字、字符串标识必须定义成常量或枚举类型没使用，方便代码阅读";
    String IssueMsg_4 = "【强制】代码必须采取措施避免运行时错误（如下标越界、分母为零、堆栈溢出）";
    String IssueMsg_5 = "【强制】代码中循环需要有明显的退出条件，不能使用goto这样的语句，避免出现死循环";
    String IssueMsg_6 = "【强制】递归需要有详细的注释说明递归的目的以及退出条件，避免无限递归问题";
    String IssueMsg_7 = "【强制】在涉及到资源占用如获取链接、IO等情况时，必须确保资源能及时释放";
    String IssueMsg_8 = "【强制】没有用到或不再用到的变量及方法要删除";
    String IssueMsg_9 = "【强制】禁止使用构造方法 BigDecimal(double)";
    String IssueMsg_10 = "【推荐】方法尽量用常用类型和实体类作为参数，少用Map类型";
    String IssueMsg_11 = "【推荐】同一段代码块如果出现两次，需要封装成方法。";
    String IssueMsg_12 = "【推荐】代码尽量保持可读性，一个class文件中的代码不要超过600行";
}