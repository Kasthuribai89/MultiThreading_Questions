package com.sukanya.Thread.Sorting;

public class SortingInThread 
{
	public static void main(String args[]) throws Exception
	{
		int a[] = {1,34,12,42,4,6,0};
		
		BubbleSort bs = new BubbleSort(a);
		SelectionSort ss = new SelectionSort(a);
		InsertionSort is = new InsertionSort(a);
		MergerSort ms = new MergerSort(a);
		QuickSort qs = new QuickSort(a);
		
		Thread thread1 = new Thread(bs);
		Thread thread2 = new Thread(ss);
		Thread thread3 = new Thread(is);
		Thread thread4 = new Thread(ms);
		Thread thread5 = new Thread(qs);
		
		thread1.start();
		thread1.join();
		 
		thread2.start();
		thread2.join();
		
		thread3.start();
		thread3.join();
		
		thread4.start();
		thread4.join();
		
		thread5.start();
	
	}
	
}
