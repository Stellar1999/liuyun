package org.liuyun.core;

/**
 * 运行时上下文定义
 * 在Processor启动时被初始化，在Step运行结束时消亡
 * 通过表达式进行操作
 */
public interface RuntimeContext {

    Object execute(Express express);
}
