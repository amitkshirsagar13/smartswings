package io.smart.swings.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadUtils {

    public static void slowDown(int slowDown) {
        Runnable slowDownRunner = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(slowDown);
                } catch (InterruptedException e) {
                    log.error("Thread slowed down {}", e.getMessage());
                }
            }
        };
        slowDownRunner.run();
    }

    public static Runnable slowDown = () -> {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error("Thread slowed down {}", e.getMessage());
        }
    };
}
