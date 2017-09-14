package com.codexa.data.coapserver;

import com.codexa.data.coapserver.api.CoapDataSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by peter on 26.7.2017.
 */
@EnableAsync
@Configuration
public class Beans {


    @Bean
    public CoapDataSender coapDataSender() {
        return new CoapDataSenderImpl();
    }


    @Bean
    public Executor asyncExecutor() {

        int availableCores = Runtime.getRuntime().availableProcessors();

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(availableCores);
        executor.setMaxPoolSize(availableCores);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Coap sender-");
        executor.initialize();
        return executor;
    }
}