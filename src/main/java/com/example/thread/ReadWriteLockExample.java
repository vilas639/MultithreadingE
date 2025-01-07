package com.eazybytes.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

	private int counter=0;
	
	private final ReadWriteLock readwritelock= new ReentrantReadWriteLock();
	
	private final Lock readlock= readwritelock.readLock();
	
	private final Lock writelock = readwritelock.writeLock();
	
	
	public void increament()
	{
		writelock.lock();
		try
		{
			
			counter++;
		}
		catch(Exception e)
		{
			writelock.unlock();
		}
		
	}
	//read  multiple on counter and write in 1 resources
	
	
	public int getcount()
	{
		
		readlock.lock();
		try
		{
			 System.out.println("counter value"+counter); 
			return counter;
			
		}
		catch(Exception e)
		{
			readlock.unlock();
		}
		
		return counter;
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ReadWriteLockExample r =new ReadWriteLockExample();
		
		
		Runnable readdata= new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println(r.getcount());
			
			}
		};
		
		
		Runnable writedata = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for (int i = 0; i < 10; i++) {
				
					System.out.println("increment data +"+i);
					r.increament();
				}
				
			}
		};
		
		
		Thread t1= new Thread(writedata);
		t1.setName("Write tread");
		Thread t2 = new Thread(readdata);
		
		t2.setName("Read tread 1");
		
		Thread t3= new Thread(readdata);
		t3.setName("Read tread 2");
		
		
		t1.start();
		Thread.sleep(10000);
		
		t2.start();
		t3.start();
		
		t1.join();
	
		t2.join();
		t3.join();
		
		
		System.out.println("transcation complted");
		
		
		
		

	}

}
