package com.jzt.sonar.java.checks.comment;

/**
 * 作者：lizw <br/>
 * 创建时间：2019/11/25 10:19 <br/>
 */
interface CommentIssueMsg {
    String IssueMsg_1 = "【强制】方法注释需要对各参数、返回值、异常、方法执行过程进行说明，要做到通过方法注释就能辨别方法是否适用";
    String IssueMsg_2 = "【强制】代码中存在临时解决方法后续要优化的必须注明TODO";
    String IssueMsg_3 = "【推荐】类注释、方法注释采用统一format规范文件";
    String IssueMsg_4 = "【推荐】关键代码方法内要加上注释对局部代码块作出解释";
}