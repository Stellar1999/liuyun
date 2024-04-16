package org.liuyun.core;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LogStep extends AbstractStep {

    private static final Logger logger = LoggerFactory.getLogger(LogStep.class);
    public static final String TYPE_NAME = "log";

    private final String text;
    public LogStep(String id, String text) {
        super(id);
        this.text = text;
    }

    @Override
    protected void run(RuntimeContext runtimeContext) {
        logger.info(this.text);
    }
}
