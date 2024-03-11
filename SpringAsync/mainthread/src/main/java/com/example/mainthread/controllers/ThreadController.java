package com.example.mainthread.controllers;

import com.example.mainthread.services.AsyncService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/threads")
@CrossOrigin
public class ThreadController {

  @Autowired AsyncService asyncService;

  @CrossOrigin
  @GetMapping("/async")
  public CompletableFuture<ResponseEntity<List<String>>> getCustomerNamesAsynchronously()
      throws InterruptedException {
    System.out.println(
        "Capturing the request from the client in thread" + Thread.currentThread().getName());
    long startTime = System.currentTimeMillis();
    CompletableFuture<ResponseEntity<List<String>>> getCustNames =
        asyncService.getCustomerByNameAsync();
    long endTime = System.currentTimeMillis();
    long timeTaken = (endTime - startTime) / 1000;
    System.out.println("Time taken for the customer facing thread to complete:" + timeTaken);

    // List<String> result = getCustNames.join(); // Get the actual result
    return getCustNames;
  }

  @GetMapping("/sync")
  public List<String> getCustomerNamesSynchronously() throws InterruptedException {
    System.out.println(
        "Capturing the request from the client in thread" + Thread.currentThread().getName());
    long startTime = System.currentTimeMillis();
    List<String> getCustNames = asyncService.getCustomerByNameSync();
    long endTime = System.currentTimeMillis();
    long timeTaken = (endTime - startTime) / 1000;
    System.out.println("Time taken for the customer facing thread to complete:" + timeTaken);

    // List<String> result = getCustNames.join(); // Get the actual result
    return getCustNames;
  }
}
