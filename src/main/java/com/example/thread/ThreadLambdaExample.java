package com.eazybytes.java.multithreading;

public class ThreadLambdaExample {

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Runnable task1 = () -> {
			System.out.println(Thread.currentThread().getName());
		};
		
		Thread t1= new Thread(task1);
		t1.start();
		
		try {
			t1.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task completed");
	}

}
