package com.example.thread;

public class Hellow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		World w= new World();
		//w.start();
		
		Thread t= new Thread(w);
		t.start();
		
		for (int i = 0; i <1000; i++) {
			
			System.out.println(Thread.currentThread().getName());
			
			
		}
	}
	

}
