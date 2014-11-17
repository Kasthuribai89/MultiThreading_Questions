package Thread1;

import java.util.Scanner;

public class WaitNotify 
{
	public static void main(String args[]) throws InterruptedException
	{
		final Processor1 p1 = new Processor1();
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
				
				try {
					p1.produce();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				
				try {
					p1.consume();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		t1.start();t2.start();
		t1.join();t2.join();
	}

}

class Processor1
{
	public void produce() throws InterruptedException
	{
		synchronized(this)
		{
			System.out.println("producer started...");
			wait();
			System.out.println("Resumed");
			
		}
	}
	
	@SuppressWarnings("resource")
	public void consume() throws InterruptedException
	{
		Scanner scan = new Scanner(System.in);
		Thread.sleep(5000);
		synchronized(this)
		{
			System.out.println("Press Enter key");
			scan.nextLine();
			notify();
			System.out.println("Enter key pressed");

		}
	}
}
