package org.liuyun.core.dsl;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.io.FileUtils;
import org.liuyun.core.Processor;
import org.liuyun.core.SimpleProcessor;
import org.liuyun.core.Step;
import org.liuyun.core.Trigger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * DSL是一个流程的描述文件，但是这个由于是模型格式具有局限性:
 * 1.一个Trigger仅会映射到一个Process
 * 2.Step为多例
 * 因此并不建议使用DSL的方式去生成流程
 */
public class DSL {
    private DSLTrigger trigger;

    private List<DSLStep> steps;


    public static DSL readDSL(File dslFile) throws IOException {
        String dslString = FileUtils.readFileToString(dslFile, StandardCharsets.UTF_8);
        return readDSL(dslString);
    }

    public static DSL readDSL(String dslJSONString){
        return JSON.parseObject(dslJSONString, DSL.class);
    }

    /**
     * 调用build后，会将DSL实例化为完整的流程对象
     * 并且返回Trigger，即这个流程的触发器
     * @return
     */
    public Trigger build(){
        // 1.首先实例化Step
        //TODO:这个算法应该还可以优化
        //1.1 找到根节点
        Set<String> nextIDSet = new HashSet<>();
        Map<String, DSLStep> idStepMap = new HashMap<>();
        for (DSLStep step : this.steps){
            if (step.getNext() != null){
                nextIDSet.addAll(step.getNext());
            }
            idStepMap.put(step.getId(), step);
        }
        Set<String> allIDSet = new HashSet<>(idStepMap.keySet());
        allIDSet.removeAll(nextIDSet);
        if (allIDSet.size() != 1){
            throw new IllegalArgumentException("开始的step不止一个");
        }
        // 1.2 开始从根节点编织结构
        Step root = buildStep(allIDSet.iterator().next(), idStepMap);
        // 2.构建Process
        // TODO:目前还没有做对Process的建模
        Processor processor = new SimpleProcessor(root);
        // 3.构建Trigger
        return this.trigger.build(processor);
    }

    private Step buildStep(String rootID,Map<String, DSLStep> dslStepMap){
        // 先构建自己
        DSLStep rootDSL = dslStepMap.get(rootID);
        Step root = rootDSL.build();
        // 构建子集
        if (rootDSL.getNext() != null){
            for (String nextID : rootDSL.getNext()){
                Step nextStep = buildStep(nextID, dslStepMap);
                root.getNext().add(nextStep);
                nextStep.getPrev().add(root);
            }
        }
        return root;
    }

    public DSLTrigger getTrigger() {
        return trigger;
    }

    public void setTrigger(DSLTrigger trigger) {
        this.trigger = trigger;
    }

    public List<DSLStep> getSteps() {
        return steps;
    }

    public void setSteps(List<DSLStep> steps) {
        this.steps = steps;
    }

}

