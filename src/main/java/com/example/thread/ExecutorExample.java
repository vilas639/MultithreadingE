package com.example.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

	public static void main1(String[] args) {
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
	
	public  static void main2(String[] args)
	{
		
		//two sequenctiak api should call in parallel to reduce time 
		
		long startTime = System.currentTimeMillis(); // start

		System.out.println(findMultiplecation(4));
		
		
		System.out.println(findMultiplecation(5));
		
		System.out.println("hi");
		
		 long endTime = System.currentTimeMillis(); // end
		 
		 long diff = endTime - startTime;

	        System.out.println("Start Time: " + startTime);
	        System.out.println("End Time: " + endTime);
	        System.out.println("Execution Time: " + diff + " ms");
		
	}
	
	
	
	public  static void main(String[] args)
	{
		
		//two sequenctiak api should call in parallel to reduce time 
		
		long startTime = System.currentTimeMillis(); // start
		
		ExecutorService e= Executors.newFixedThreadPool(2);

	 Future<String> res1 =	(Future<String>) e.submit( new Runnable() {
			public void run() {
				System.out.println(findMultiplecation(4));
			}
		});
	 
	 Future<String> res2 =	(Future<String>) e.submit( new Runnable() {
			public void run() {
				System.out.println(findMultiplecation(5));
			}
		});
		
		
	   try {
		res1.get();
		res2.get();
		
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ExecutionException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  finally {
		e.shutdown();
	}
		
		System.out.println("hi");
		
		 long endTime = System.currentTimeMillis(); // end
		 
		 long diff = endTime - startTime;

	        System.out.println("Start Time: " + startTime);
	        System.out.println("End Time: " + endTime);
	        System.out.println("Execution Time: " + diff + " ms");
	        
	        
		
	}
	

	
	static int findMultiplecation(int number)
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	  return number*number;
	}
}
