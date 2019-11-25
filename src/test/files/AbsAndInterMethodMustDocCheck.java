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

    /**
     * 全局执行的任务(JVM内同一时刻只有一个线程执行)
     *
     * @throws Throwable qwqw
     */
    protected abstract void internalExecute() throws Throwable;
}