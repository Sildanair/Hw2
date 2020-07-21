package task1;

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Multiplicate {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int threadCount = 16;
        Counter[] counters  = new Counter[threadCount];
        BigInteger maxI = BigInteger.valueOf(100_000L);
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            counters[i] = new Counter(
                    maxI.multiply(BigInteger.valueOf(i)).divide(BigInteger.valueOf(threadCount)).add(BigInteger.ONE),
                    maxI.multiply(BigInteger.valueOf(i + 1)).divide(BigInteger.valueOf(threadCount)));
           // executorService.execute(counters[i]);

        }

        LocalDateTime startDateTime = LocalDateTime.now();
        List<Future<BigInteger>> futures = executorService.invokeAll(Arrays.asList(counters));
        LocalDateTime endDateTime = LocalDateTime.now();
        executorService.shutdown();
        BigInteger mult = BigInteger.ONE;
        for (Future<BigInteger> future : futures)
        {
            mult = mult.multiply(future.get());
        }

        System.out.println(String.format("mult: %d", mult));
        System.out.println(String.format("time: %d ms", Duration.between(startDateTime, endDateTime).toMillis()));
    }
}
