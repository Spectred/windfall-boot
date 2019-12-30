package com.spectred.alpha.listeners;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * An ApplicationContextInitializedEvent is sent when the ApplicationContext is prepared and ApplicationContextInitializers
 * have been called but before any bean definitions are loaded.
 * @author SWD
 */
public class ApplicationContextInitializedListener implements ApplicationListener<ApplicationContextInitializedEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent applicationContextInitializedEvent) {
        System.out.println("---> ApplicationContextInitializedListener");
    }
}
