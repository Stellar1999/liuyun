package org.liuyun.core.dsl;

import org.liuyun.core.LogStep;
import org.liuyun.core.Step;

import java.util.List;

public class DSLStep {

    /**
     * 唯一标识
     */
    private String id;

    /**
     * 步骤类型
     */
    private String type;

    /**
     * 下一个节点
     */
    private List<String> next;

    /**
     * 日志节点的操作配置
     */
    private String text;

    protected Step build(){
        switch (type){
            case LogStep.TYPE_NAME:
                return buildLogStep();
        }
        throw new IllegalArgumentException("找不到DSL描述的Step-Type");
    }

    private LogStep buildLogStep(){
        return new LogStep(id, text);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getNext() {
        return next;
    }

    public void setNext(List<String> next) {
        this.next = next;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
