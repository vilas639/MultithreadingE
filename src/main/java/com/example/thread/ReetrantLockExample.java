package com.eazybytes.java.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockExample {

	
	private final Lock lock= new ReentrantLock();
	
	
	public void outermethod()
	{
		lock.lock();
		
		try
		{
			System.out.println("Outer Method Running");
			innermethod();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
			lock.unlock();
		}
	}
	
	public void innermethod()
	{
		lock.lock();
		
		try
		{
			System.out.println("Inner Method Running");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ReetrantLockExample r= new ReetrantLockExample();
		
		r.outermethod();
	}

}
