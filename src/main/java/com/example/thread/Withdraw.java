package com.eazybytes.java.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Withdraw {
	
	private double amount=100;
	
	private final Lock lock =new ReentrantLock();
	
	public  void withdrawamt(double amt)
	{
		
		try
		{
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS))
			{
				
				if(amt >0)
				{   try
				{
					
					System.out.println("withdra amount"+amt);
					Thread.sleep(3000);
					amount -=amt;
					System.out.println(Thread.currentThread().getName() +"" + "Remain Balanace"+ amount);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally {
					lock.unlock();
				}
					
				}
				else
				{
					System.out.println(Thread.currentThread().getName() +"" + "Insuffiect Baklance "+ amount);
				}
			}
			else
			{
				System.out.println("could not aquired lock "+Thread.currentThread().getName());
			}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
