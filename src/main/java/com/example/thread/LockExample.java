package com.eazybytes.java.multithreading;

public class LockExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		Withdraw w= new Withdraw();
		
		Runnable n= new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				w.withdrawamt(30);
				
			}
		};
		
		
		Thread t1 = new Thread(n);
		t1.setName("withdraw 1");
		
		Thread t2 = new Thread(n);
		t2.setName("withdraw 2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.join();
		
		
		System.out.println("Transcation Completed");
		
		
		
		
		
		
		
	}

}
