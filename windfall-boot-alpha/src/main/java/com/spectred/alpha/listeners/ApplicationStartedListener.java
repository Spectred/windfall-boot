package com.spectred.alpha.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * An ApplicationStartedEvent is sent after the context has been refreshed but before any application and command-line runners have been called.
 *
 * @author SWD
 */
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("---> ApplicationStartedListener");
    }
}
