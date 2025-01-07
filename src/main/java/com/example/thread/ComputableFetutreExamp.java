package com.eazybytes.java.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ComputableFetutreExamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		CompletableFuture<String> c=	CompletableFuture.supplyAsync(() -> {
			System.out.println("Welcome");
			
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			return "ok";
		});
		
		
		CompletableFuture<String> c1=	CompletableFuture.supplyAsync(() -> {
			System.out.println("Welcome1");
			
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			return "ok1";
		});
		
		
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
		
		CompletableFuture<Void> c2=CompletableFuture.allOf(c,c1);
		
		c2.join();
		
		System.out.println("Main Method is done");
		

	}

}
