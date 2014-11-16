package com.sukanya.producer_Consumer;

public class Producer extends Thread
{
	private blockingQueue queue;
	private int number;
	Producer(blockingQueue queue,int number)
	{
		this.queue = queue;
		this.number = number;
	}
	public void run()
	{
		for (int i = 0; i < 10; i++) 
		{
			queue.put(i);
			System.out.println("Producer #" + this.number
					+ " put: " + i);
			try 
			{
				sleep((int)(Math.random() * 100));
			}
			catch (InterruptedException e) { }
		}
		
	}
}
