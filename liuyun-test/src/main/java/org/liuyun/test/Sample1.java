package org.liuyun.test;

import org.apache.commons.io.FileUtils;
import org.liuyun.core.Trigger;
import org.liuyun.core.dsl.DSL;

import java.io.File;
import java.io.IOException;

public class Sample1 {

    public static void main(String[] args) throws InterruptedException, IOException {
        // get file from resource Sample1.json
        String basePath = new File("").getAbsolutePath();
        File jsonFile = new File(basePath+"/liuyun-test/src/main/resources/Sample1.json");
        String jsonString = FileUtils.readFileToString(jsonFile);
        Trigger trigger = DSL.readDSL(jsonString).build();
        trigger.register();
        Thread.sleep(1000*1000*60);
    }
}
