package com.ams;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHook {
    @PreDestroy
    public void cleanUp() {
        System.out.println("Shutting down thread pools...");
        // Cleanup logic if necessary
    }
}
