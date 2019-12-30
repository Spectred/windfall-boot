package com.spectred.leaf.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 在声明Bean时,根据条件判断是否创建该Bean
 *
 * @author SWD
 */
public class SomeCondition implements Condition {

    private static final boolean LOAD = false;

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println("SomeCondition:" + LOAD);
        return LOAD;
    }
}
