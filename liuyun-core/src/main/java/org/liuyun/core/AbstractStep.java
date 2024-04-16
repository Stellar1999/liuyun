package org.liuyun.core;

import com.alibaba.fastjson2.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStep implements Serializable, Step {

    private String id;
    private List<Step> prev = new ArrayList<>();

    private List<Step> next = new ArrayList<>();

    public AbstractStep(String id){
        this.id = id;
    }

    @Override
    public void execute(RuntimeContext runtimeContext) {
        run(runtimeContext);
        for (Step nextStep : this.getNext()){
            nextStep.execute(runtimeContext);
        }
    }

    protected abstract void run(RuntimeContext runtimeContext);

    public List<Step> getPrev() {
        return prev;
    }
    public List<Step> getNext() {
        return next;
    }

    public void setPrev(List<Step> prev) {
        this.prev = prev;
    }
    public void setNext(List<Step> next) {
        this.next = next;
    }


}
