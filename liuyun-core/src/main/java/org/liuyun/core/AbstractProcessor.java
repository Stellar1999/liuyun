package org.liuyun.core;

public abstract class AbstractProcessor implements Processor {

    private Step begin;

    public AbstractProcessor(Step root){
        this.begin = root;
    }

    @Override
    public void run() {
        RuntimeContext runtimeContext = new SimpleRuntimeContext();
        begin.execute(runtimeContext);
        //TODO:对Context做处理
    }



}
