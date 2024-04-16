package org.liuyun.core;

import java.util.List;

public class Express {

    private String op;

    private List<String> tokens;

    public Express(String expressString){
        validate(expressString);
        //TODO 拆分语法单元
    }

    private void validate(String expressString){
        //TODO: 检查表达式是否合法
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }



}
