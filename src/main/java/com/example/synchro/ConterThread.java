package com.example.synchro;

import javax.management.loading.PrivateClassLoader;

public class ConterThread extends Thread {

	private CounterData counterdata;
	
	
	ConterThread(CounterData c)
	{
		this.counterdata=c;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 1000; i++) {
			
			counterdata.increment();
		}
	
	}

}
