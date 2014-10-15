package com.sukanya.DeadLock;

public class DeadLock_Example 
{
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	
	public static void main(String args[])
	{
		ThreadDemo1 thread1 = new ThreadDemo1();
		ThreadDemo2 thread2 = new ThreadDemo2();
		
		thread1.start();
		thread2.start();
	}
	private static class ThreadDemo1 extends Thread
	{
		public void run()
		{
			synchronized(lock1)
			{
				System.out.println("Thread 1: holding lock1");
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e){}
				System.out.println("Thread 1: Waiting for lock2");
				synchronized(lock2)
				{
					System.out.println("Thread 1: holding for lock1 and lock2");
				}
			}
		}
	}
	
	private static class ThreadDemo2 extends Thread
	{
		public void run()
		{
			synchronized(lock2)
			{
				System.out.println("Thread 2: holding lock2");
				try
				{
					Thread.sleep(10);
				}
				catch(Exception e){}
				System.out.println("Thread 2: Waiting for lock1");
				synchronized(lock1)
				{
					System.out.println("Thread 2: holding for lock1 and lock2");
				}
			}
		}
	}
	
}
