package com.tom.yang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
@ExtendWith(MockitoExtension.class)
class TestVirtualThreads {

    @Test
    void test_thread() {
        Runnable runnable = () -> log.info("Hello from thread");

        Thread.ofVirtual().name("test virtual thread").start(runnable);

        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()){
            IntStream.range(0, 10).forEach(i -> executorService.submit(runnable));
        }

    }
}
