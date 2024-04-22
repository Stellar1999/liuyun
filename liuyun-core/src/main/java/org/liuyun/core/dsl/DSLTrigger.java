package org.liuyun.core.dsl;

import org.liuyun.core.trigger.CronTrigger;
import org.liuyun.core.processor.Processor;
import org.liuyun.core.trigger.Trigger;

public class DSLTrigger {

    private String type;

    private String beginTime;

    private String endTime;

    private Long delay;

    public Trigger build(Processor processor) {
        switch (type) {
            case CronTrigger.type:
                return buildCronTrigger(processor);
        }
        throw new IllegalArgumentException("找不到DSL描述的Trigger-Type");
    }

    private Trigger buildCronTrigger(Processor processor) {
        return new CronTrigger(processor, this.delay);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }
}
