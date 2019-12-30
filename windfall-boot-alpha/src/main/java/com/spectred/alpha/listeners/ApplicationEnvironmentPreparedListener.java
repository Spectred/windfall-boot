package com.spectred.alpha.listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * An ApplicationEnvironmentPreparedEvent is sent when the Environment to be used in the context is known but before the context is created.
 * 环境已经准备完毕，但此时上下文还有没创建
 *
 * @author SWD
 */
public class ApplicationEnvironmentPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println("---> ApplicationEnvironmentPreparedListener");
    }
}
