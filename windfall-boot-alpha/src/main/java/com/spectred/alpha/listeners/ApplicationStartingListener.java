package com.spectred.alpha.listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * An ApplicationStartingEvent is sent at the start of a run but before any processing, except for the registration of listeners and initializers.
 * 应用开始执行启动前
 *
 * @author SWD
 */
public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("---> ApplicationStartingListener");
    }
}
