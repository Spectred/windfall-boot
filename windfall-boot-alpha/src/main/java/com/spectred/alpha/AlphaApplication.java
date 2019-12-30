package com.spectred.alpha;

import com.spectred.alpha.listeners.ApplicationContextInitializedListener;
import com.spectred.alpha.listeners.ApplicationEnvironmentPreparedListener;
import com.spectred.alpha.listeners.ApplicationFailedListener;
import com.spectred.alpha.listeners.ApplicationPreparedListener;
import com.spectred.alpha.listeners.ApplicationReadyListener;
import com.spectred.alpha.listeners.ApplicationStartedListener;
import com.spectred.alpha.listeners.ApplicationStartingListener;
import com.spectred.alpha.listeners.ContextRefreshedListener;
import com.spectred.alpha.listeners.WebServerInitializedListener;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AlphaApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AlphaApplication.class);
        // 添加监听器
        addListeners(springApplication);

        springApplication.run(args);


        // 自定义退出码
//        System.exit(SpringApplication.exit(SpringApplication.run(AlphaApplication.class, args)));
    }

    private static void addListeners(SpringApplication springApplication) {
        springApplication.addListeners(new ApplicationStartingListener());
        springApplication.addListeners(new ApplicationEnvironmentPreparedListener());
        springApplication.addListeners(new ApplicationContextInitializedListener());
        springApplication.addListeners(new ApplicationPreparedListener());
        springApplication.addListeners(new ApplicationStartedListener());
        springApplication.addListeners(new ApplicationReadyListener());
        springApplication.addListeners(new ApplicationFailedListener());

        springApplication.addListeners(new ContextRefreshedListener());
        springApplication.addListeners(new WebServerInitializedListener());
    }

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 100;
    }


}
