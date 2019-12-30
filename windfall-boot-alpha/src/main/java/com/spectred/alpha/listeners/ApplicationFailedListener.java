package com.spectred.alpha.listeners;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * An ApplicationFailedEvent is sent if there is an exception on startup.
 *
 * @author SWD
 */
public class ApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent> {
    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
        System.out.println("---> ApplicationFailedListener");
    }
}
