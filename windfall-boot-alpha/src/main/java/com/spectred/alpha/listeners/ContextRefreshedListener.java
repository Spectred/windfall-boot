package com.spectred.alpha.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * A ContextRefreshedEvent is sent when an ApplicationContext is refreshed.
 *
 * @author SWD
 */
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("---> ContextRefreshedListener");
    }
}
