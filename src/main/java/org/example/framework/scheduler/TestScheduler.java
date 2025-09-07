package org.example.framework.scheduler;

import org.example.framework.schtests.GitHubApiTests;
import org.example.framework.schtests.GitHubTests;
import org.example.framework.schtests.W3SchoolsTests;
import org.example.framework.schtests.WikipediaTests;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduler {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Scheduled task started at: " + LocalDateTime.now());

            ExecutorService parallelExecutor = Executors.newFixedThreadPool(4);

            try {
                // Using instance method references
                parallelExecutor.submit(() -> runAndExport(new GitHubTests()::runAllTests));
                parallelExecutor.submit(() -> runAndExport(new GitHubApiTests()::runAllTests));
                parallelExecutor.submit(() -> runAndExport(new W3SchoolsTests()::runAllTests));
                parallelExecutor.submit(() -> runAndExport(new WikipediaTests()::runAllTests));

                parallelExecutor.shutdown();
                parallelExecutor.awaitTermination(15, TimeUnit.MINUTES);

                System.out.println("All tests executed successfully at: " + LocalDateTime.now());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        LocalTime targetTime = LocalTime.of(21, 53); // schedule time
        long initialDelay = computeInitialDelay(targetTime);
        long period = TimeUnit.DAYS.toSeconds(1);

        System.out.println("Initial delay in seconds: " + initialDelay);
        scheduler.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    // Compute initial delay until first run
    private static long computeInitialDelay(LocalTime targetTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextRun = now.withHour(targetTime.getHour())
                .withMinute(targetTime.getMinute())
                .withSecond(0).withNano(0);
        if (now.compareTo(nextRun) >= 0) nextRun = nextRun.plusDays(1);
        return Duration.between(now, nextRun).getSeconds();
    }

    // Wrapper to safely run tests
    private static void runAndExport(Runnable testRunnable) {
        testRunnable.run();
        // Each test should internally call ExcelAndDbExporter.exportResult()
    }
}
