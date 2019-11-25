package com.rule.test.Enumtest;

import java.io.IOException;

/**
 * @author lizw
 */
public abstract class AbstractJocDemo {

    public abstract void aa(); // Noncompliant

    /**
     * 这是bb方法
     *
     * @param b 参数b
     * @return 返回值
     */
    public abstract int bb(int b);

    /**
     * 这是cc方法
     *
     * @throws IOException
     */
    public abstract void cc() throws IOException;
}


/**
 * 作者：lizw <br/>
 * 创建时间：2017/9/15 21:06 <br/>
 */
interface BaseClient {
    /**
     * 视图页面(JSP)的后缀
     */
    String JSON_SUFFIX = ".json";
}