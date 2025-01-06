package com.example.synchro;

public class CounterData {
	
	private int counter=0;
	
	
	
	
	CounterData()
	{
		
	}
	
	
	
	public synchronized void increment()
	{
		counter++;
	}
	
	public int getcount()
	{
		return counter;
	}

}
