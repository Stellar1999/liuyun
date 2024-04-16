package org.liuyun.core;

import java.util.concurrent.TimeUnit;

public class CronTrigger implements Trigger {

    public static final String type = "cron";

    private Processor processor;

    private long delay;

    public CronTrigger(Processor processor, long delay){
        this.processor = processor;
        this.delay = delay;
    }

    public void register(){
        ThreadPoolUtils.executorService.scheduleAtFixedRate(()->processor.run(),0,  delay, TimeUnit.SECONDS);
    }
}
