package com.spectred.alpha.listeners;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * A WebServerInitializedEvent is sent after the WebServer is ready. ServletWebServerInitializedEvent and ReactiveWebServerInitializedEvent are the servlet and reactive variants respectively.
 *
 * @author SWD
 */
public class WebServerInitializedListener implements ApplicationListener<WebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        System.out.println("---> WebServerInitializedListener");
    }
}
