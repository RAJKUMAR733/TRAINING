package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Implementation {


    public static void compute() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
            int sum=0;
            for (int i=1; i<=10; i++){
                sum=sum+i;
            }
            return sum;
        });
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            int sum=0;
            for (int i=11; i<=20; i++){
                sum=sum+i;
            }
            return sum;
        });
        CompletableFuture<Integer> completableFuture3 = CompletableFuture.supplyAsync(()->{
            int sum=0;
            for (int i=21; i<=30; i++){
                sum=sum+i;
            }
            return sum;
        });

        CompletableFuture<Integer> overall = completableFuture1.thenCombine(completableFuture2,(x,y) -> x+y)
                .thenCombine(completableFuture3,(totalsum,z) -> totalsum+z);
        System.out.println(overall.get());

    }

}
