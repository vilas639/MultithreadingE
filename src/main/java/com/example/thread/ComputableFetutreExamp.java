package com.example.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ComputableFetutreExamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService excutor= Executors.newFixedThreadPool(3);
		
		CompletableFuture<String> c=	CompletableFuture.supplyAsync(() -> {
			System.out.println("user");
			
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			return "user data";
		},excutor);
		
		
		//chaning 
		CompletableFuture<String> c1=	CompletableFuture.supplyAsync(() -> {
			System.out.println("order");
			
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			return "order data";
		}).thenApply(res -> {
			return res+" bye";
		}).thenApply(res -> {
			return res.toUpperCase();
		}).exceptionallyAsync(ex -> {
			
			return "Handled exception: " + ex.getMessage();

		},excutor);
		
		
		CompletableFuture<String> c2=	CompletableFuture.supplyAsync(() -> {
			System.out.println("account");
			
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			return "account data ";
		}).thenApply(res -> {
			return res+" bye";
		}).thenApply(res -> {
			return res.toUpperCase();
		}).exceptionallyAsync(ex -> {
			
			return "Handled exception: " + ex.getMessage();

		},excutor);
		
		
		
		String s=null;
		
		try
		{
			s=c.get();
			System.out.println(s);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
String s1=null;
		
		try
		{
			s1=c1.get();
			System.out.println(s1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			s1=c2.get();
			System.out.println(s1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		CompletableFuture<Void> result=CompletableFuture.allOf(c,c1,c2);
		
		// CompletableFuture<String> result = c.thenCombine(c1, (user, order) -> {
	     //       return user + " + " + order;
	      //  });


		//result.join();
		
		CompletableFuture<String> combinedFuture = c.thenCombine(c1, (user, account) -> {
            return user + " | " + account;
        }).thenCombine(c2, (partialResult, transactions) -> {
            return partialResult + " | " + transactions;
        });

        // Get the Final Result
        System.out.println("Final Response: " + combinedFuture.join());

		//System.out.println("Final Response: " + result.join());

		
		System.out.println("Main Method is done");
		
		
		// Shutdown the executor
		excutor.shutdown();

		

	}

}
