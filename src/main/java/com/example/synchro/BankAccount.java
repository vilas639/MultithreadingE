package com.example.synchro;

public class BankAccount {
	
	
	private double amount;
	
	
	public synchronized void withdraw(double amt)
	{
		
		if(amt >0)
		{
			amount =amount-amt;
			
			System.out.println(Thread.currentThread().getName() +" "+" Withdraw amot"+ amt);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +" "+" Remain balance"+ amount);
		}
		else
		{
			System.out.println(Thread.currentThread().getName() +" "+" Insufficent balance"+ amt);
		}
	}
	
	

}
