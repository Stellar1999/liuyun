package org.liuyun.core;

import java.util.List;

/**
 * Step可以理解为一个节点，是整个流云引擎的最小单元，每个Step都有自身的行为
 * 多个Step组成一个有向无环图，可以按照顺序依次执行
 * Step必须是无状态的，数据流转通过Context进行流转
 * 这个图的开始节点只有一个
 */
public interface Step {

    void execute(RuntimeContext runtimeContext);

    List<Step> getPrev();

    List<Step> getNext();

    void setPrev(List<Step> prev);

    void setNext(List<Step> next);
}
