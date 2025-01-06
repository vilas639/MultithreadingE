package com.example.synchro;

public class LockExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		BankAccount b= new BankAccount();
		
		
		
		 Runnable r= new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				b.withdraw(30);
				
			}
		};
		
		
		Thread t1= new Thread(r);
		t1.setName("withdraw 1");
		
		Thread t2= new Thread(r);
		t2.setName("Withdraw 2");
		
		t1.start();
		
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("transcation complted ");
		System.out.println("Remain balance ");
		
		
		
	}

}
