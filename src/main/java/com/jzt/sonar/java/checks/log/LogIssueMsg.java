package com.jzt.sonar.java.checks.log;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 10:22 <br/>
 */
interface LogIssueMsg {
    String IssueMsg_1 = "【强制】try-catch代码必须进行日志记录";
    String IssueMsg_2 = "【强制】禁止使用e.printStackTrace()";
    String IssueMsg_3 = "【推荐】关键业务代码要进行日志打印";
    String IssueMsg_4 = "【推荐】日志信息脱敏";
    String IssueMsg_5 = "【推荐】日志级别";
}
