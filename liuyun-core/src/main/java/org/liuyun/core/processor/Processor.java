package org.liuyun.core.processor;

/**
 * Processor(进程)是一串Step的管理者，通过Processor#run()可以启动一个流程，使其依次Step执行
 */
public interface Processor {

    void run();
}
