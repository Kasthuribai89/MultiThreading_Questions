package com.sukanya.producer_Consumer;

public class Consumer extends Thread
{
	blockingQueue queue;
	private int number;
	Consumer(blockingQueue queue,int number)
	{
		this.queue = queue;
		this.number = number;
	}
	
	public void run()
	{
		int value = 0;
	
    for (int i = 0; i < 10; i++) 
    {
        value = queue.get();
        System.out.println("Consumer #" + this.number+ " got: " + value);
     }
	}
}
