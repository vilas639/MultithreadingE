package com.example.thread;

public class World implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i <1000; i++) {
		
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//		
//		for (int i = 0; i <1000; i++) {
//		
//			System.out.println(Thread.currentThread().getName());
//		}
//	}

}
