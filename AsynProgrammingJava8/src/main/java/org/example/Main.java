package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
  public static void main(String[] args) throws InterruptedException, ExecutionException {

    long startTime = System.currentTimeMillis();
    System.out.println("Thread Name: " + Thread.currentThread().getName());

    Runnable printFactorialRunnable = getFactorialRunnable();

    CompletableFuture<Void> completableFuture =
        CompletableFuture.runAsync(printFactorialRunnable)
            .thenRun(() -> System.out.println("Execution completed"));

    long endTime = System.currentTimeMillis();
    long timeTaken = (endTime - startTime);
    System.out.println("Time Taken to complete main thread execution" + timeTaken);

    completableFuture.get();

    Completable.co
  }

  public static int factorial(int num) throws InterruptedException {
    Thread.sleep(5000);
    System.out.println(Thread.currentThread().getName());
    if (num < 0) {
      return -1;
    } else if (num == 0 || num == 1) {
      return 1;
    } else {
      int factorial = 1;
      for (int i = num; i > 0; i--) {
        factorial = factorial * i;
      }
      return factorial;
    }
  }

  private static Runnable getFactorialRunnable() {
    return () -> {
      try {
        System.out.println(factorial(10));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };
  }
}
