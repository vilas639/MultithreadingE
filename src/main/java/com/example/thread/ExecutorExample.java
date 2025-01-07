package com.eazybytes.java.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ExecutorService excutor= Executors.newFixedThreadPool(3);
		ExecutorService excutor= Executors.newSingleThreadExecutor();
		
		//ExecutorService excutor= Executors.newCachedThreadPool();
		
		ExecutorService excutor1= Executors.newSingleThreadExecutor();

		CountDownLatch l = new CountDownLatch(3);
		
		ScheduledExecutorService sheduler= Executors.newScheduledThreadPool(1);
		
		for (int i = 0; i <10; i++) {
			
			int finali=i;
			Future<?> future= excutor.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					System.out.println(findMultiplecation(finali));
				}
			});
			
			try {
				future.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(future.isDone())
			{
				System.out.println("task done" +finali);
			}
			
			
		}
		
		
		
		excutor.shutdown();
		
		
       try {
		excutor.awaitTermination(1, TimeUnit.SECONDS);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		System.out.println(System.currentTimeMillis());
		
		
		
		sheduler.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Welcome after 5 sec");
			}
		}, 5, TimeUnit.SECONDS);
		
		
          sheduler.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Welcome after 5 sec");
			}
		}, 5,5, TimeUnit.SECONDS);
		
		
          sheduler.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				sheduler.shutdown();
			}
		}, 30, TimeUnit.SECONDS);
          
          
         
          excutor1.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					l.countDown();
				}
			}
		});

          
          try {
			l.await(5,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          System.out.println("Final Thread is Runnign");
          
		
	}

	
	static int findMultiplecation(int number)
	{
	  return number*number;
	}
}
