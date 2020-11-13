package com.setinel.util;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Drainli
 **/
public class SentinelRulesUtils {

    /**
     *  初始化限流规则
     */
    public  void initFlowRules() {
        FlowRule rule = new FlowRule() ;
        List<FlowRule> rules = new ArrayList<>() ;

        rule.setClusterMode(false) ;
        rule.setCount(10) ;
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS) ;
        rule.setStrategy(RuleConstant.STRATEGY_CHAIN) ;
        rule.setLimitApp("default") ;
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT) ;

        rules.add(rule) ;
        FlowRuleManager.loadRules(rules);
    }
}
