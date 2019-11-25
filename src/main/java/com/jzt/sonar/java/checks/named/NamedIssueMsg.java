package com.jzt.sonar.java.checks.named;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/22 18:01 <br/>
 */
interface NamedIssueMsg {

    String IssueMsg_1 = "【强制】类名、方法名、成员变量采用标准驼峰规则。类名首字母大写，方法名、成员变量首字母小写";
    String IssueMsg_2 = "【强制】终态变量命名采用全大写以下划线分割";
    String IssueMsg_3 = "【推荐】各种命名必须表意准确、尽可能短，除2代替‘to’，4代替‘for’外，不建议在命名中使用数字";
    String IssueMsg_4 = "【推荐】通过方法名称要能识别方法的作用";
}













