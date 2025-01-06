package com.example.thread;

public class ThreadState extends Thread {

	//start run sleep join priority intrrupt  yield
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		System.out.println("Running");
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println(Thread.currentThread().getName() + " "+Thread.currentThread().getPriority() + " "+ i);
			try
			{
				Thread.sleep(200);
				
				System.out.println("running max line");
				
				Thread.yield();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//three thrad make priorty
		
		ThreadState t1= new ThreadState();
		Thread t= new Thread(t1);
		t.setName("vikas");
		
		
		Thread t2= new Thread(t1);
		t2.setName("vilas");
		
		Thread t3= new Thread(t1);
		t3.setName("jaya");
		
		System.out.println(t.getState());
		
		t.setPriority(NORM_PRIORITY);
		t.start();
		t2.setPriority(MAX_PRIORITY);
		t2.start();
		t3.setPriority(MIN_PRIORITY);
		t3.start();
		
		System.out.println(t.getState());
		
		t2.interrupted();
		t3.interrupt();
		Thread.sleep(100);
		
		t.setDaemon(true);
		
		System.out.println(t.getState());
       
		 t.join();
		 
		System.out.println(t.getState()); 
	}

}
