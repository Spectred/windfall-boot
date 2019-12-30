package com.spectred.alpha.listeners;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * An ApplicationPreparedEvent is sent just before the refresh is started but after bean definitions have been loaded.
 * spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的
 * @author SWD
 */
public class ApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        System.out.println("---> ApplicationPreparedListener");
    }
}
