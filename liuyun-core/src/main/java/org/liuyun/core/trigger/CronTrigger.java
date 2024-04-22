package org.liuyun.core.trigger;

import java.util.concurrent.TimeUnit;

import org.liuyun.core.processor.Processor;
import org.liuyun.common.ThreadPoolUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CronTrigger implements Trigger {

    private static final Logger logger = LoggerFactory.getLogger(CronTrigger.class);

    public static final String type = "cron";

    private Processor processor;

    private long delay;

    public CronTrigger(Processor processor, long delay) {
        this.processor = processor;
        this.delay = delay;
    }

    public void register() {
        ThreadPoolUtils.executorService.scheduleAtFixedRate(
                () -> {
                    try {
                        processor.run();
                    } catch (Exception e) {
                        logger.error("定时任务触发器执行失败:", e);
                    }
                },
                0,
                delay,
                TimeUnit.SECONDS);
    }
}
