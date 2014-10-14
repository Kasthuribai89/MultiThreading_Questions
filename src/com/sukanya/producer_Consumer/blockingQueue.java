package com.sukanya.producer_Consumer;

public class blockingQueue 
{
	int item ;
	boolean available = false;
	
	public synchronized void put(int value) 
	{
	      while (available == true) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) { 
	         } 
	      }
	    
	      item = value;
	      available = true;
	      notifyAll();
	  }
	
	public synchronized int get()
	{
		while(available == false)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e){}
		}
		
		available = false;
		 notifyAll();
		 return item;
	}
}
