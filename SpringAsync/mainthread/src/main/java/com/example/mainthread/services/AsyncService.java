package com.example.mainthread.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

@Async
    public CompletableFuture<ResponseEntity<List<String>>> getCustomerByNameAsyncV1() throws InterruptedException {
    System.out.println("ThreadName: Before Sleep "+Thread.currentThread().getName());
    Thread.sleep(10000);
    ResponseEntity<List<String>> customerName= new ResponseEntity<>(Arrays.asList("Gaurav","Sonu","Ashish","Sandeep","Amit"), HttpStatus.OK);
    var m2=CompletableFuture.completedFuture(customerName);
    System.out.println("ThreadName: After sleep "+ Thread.currentThread().getName());

    return m2;
}

    @Async
    public CompletableFuture<ResponseEntity<List<String>>> getCustomerByNameAsyncV2() throws InterruptedException {
        System.out.println("ThreadName: Before Sleep "+Thread.currentThread().getName());
        Thread.sleep(3000);
        ResponseEntity<List<String>> customerName= new ResponseEntity<>(Arrays.asList("Gaurav","Sonu","Ashish","Sandeep","Amit"), HttpStatus.OK);
        var m2=CompletableFuture.completedFuture(customerName);
        System.out.println("ThreadName: After sleep "+ Thread.currentThread().getName());

        return m2;
    }

    public List<String> getCustomerByNameSyncV1() throws InterruptedException {
        System.out.println(" Sync ThreadName: Before Sleep "+Thread.currentThread().getName());
        Thread.sleep(10000);
        List<String> customerName= Arrays.asList("Gaurav","Sonu","Ashish","Sandeep","Amit");
        System.out.println("ThreadName: After sleep "+ Thread.currentThread().getName());
        return (customerName);
    }

    public List<String> getCustomerByNameSyncV2() throws InterruptedException {
        System.out.println(" Sync ThreadName: Before Sleep "+Thread.currentThread().getName());
        Thread.sleep(2000);
        List<String> customerName= Arrays.asList("Gaurav","Sonu","Ashish","Sandeep","Amit");
        System.out.println("ThreadName: After sleep "+ Thread.currentThread().getName());
        return (customerName);
    }
}
