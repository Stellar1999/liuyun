package org.liuyun.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.liuyun.core.trigger.Trigger;
import org.liuyun.core.dsl.DSL;

public class Sample1 {

    public static void main(String[] args) throws IOException {
        // get file from resource Sample1.json
        String basePath = new File("").getAbsolutePath();
        File jsonFile = new File(basePath + "/liuyun-test/src/main/resources/Sample1.json");
        String jsonString = FileUtils.readFileToString(jsonFile, StandardCharsets.UTF_8);
        Trigger trigger = DSL.readDSL(jsonString).build();
        trigger.register();
    }
}
