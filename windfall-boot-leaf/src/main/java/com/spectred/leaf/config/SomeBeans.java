package com.spectred.leaf.config;

import com.spectred.leaf.bean.ServiceA;
import com.spectred.leaf.bean.ServiceB;
import com.spectred.leaf.bean.ServiceC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * ConditionalOnXXX: 详细参考${@link org.springframework.boot.autoconfigure.condition}
 */
@Configuration
public class SomeBeans {

    /*
     * 未举例的注解:
     * ConditionalOnClass   Classpath有指定的类则加载该Bean
     * ConditionalOnMissingClass    Classpath没有指定的类则加载该Bean
     * ConditionalOnExpression  给定的EL表达式结果为true
     * ...
     */


    /**
     * 根据{@link SomeCondition}判断是否加载该Bean
     *
     * @return
     */
    @Bean
    @Conditional(SomeCondition.class)
    public ServiceA myServiceA() {
        return new ServiceA();
    }

    /**
     * 若已配置了某个特定的bean，则加载该Bean
     *
     * @return
     */
    @Bean
    @ConditionalOnBean(ServiceA.class)
    public ServiceB myServiceB() {
        return new ServiceB();
    }


    /**
     * 若没有特定的bean，则加载该Bean
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ServiceA.class)
    public ServiceC myServiceC() {
        return new ServiceC();
    }


}
