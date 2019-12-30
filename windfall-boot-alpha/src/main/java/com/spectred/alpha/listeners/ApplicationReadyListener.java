package com.spectred.alpha.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * An ApplicationReadyEvent is sent after any application and command-line runners have been called. It indicates that the application is ready to service requests.
 *
 * @author SWD
 */
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("---> ApplicationReadyListener");
    }
}
