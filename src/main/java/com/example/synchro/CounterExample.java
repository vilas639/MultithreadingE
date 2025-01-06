package com.example.synchro;

public class CounterExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		 CounterData d= new CounterData();
		
		 ConterThread  t= new ConterThread(d);
		t.setName("counter 1");
		
		ConterThread t1= new ConterThread(d);
		t1.setName("counter 2");
		
		t.start();
		
		t1.start();
		
		t.join();
		t1.join();
		
		System.out.println("count completed ");
		
	System.out.println(d.getcount());
		
		
	}

}
