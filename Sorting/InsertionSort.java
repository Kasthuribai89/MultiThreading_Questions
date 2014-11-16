package com.sukanya.Thread.Sorting;

import java.util.LinkedList;

public class InsertionSort implements Runnable
{
	int a[];
	
	InsertionSort(int a[])
	{
		this.a = a;
	}
	public void run()
	{
		long startTime = System.nanoTime();
		LinkedList<Integer> list = new LinkedList();
		int length = a.length;
		
		for(int i=1;i<length;i++)
		{
			
			for(int j=i;j>0;j--)
			{
				if(a[j] < a[j-1])
				{
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		
		for(int i=0;i<length;i++)
		{
			list.add(a[i]);
		}
		
		System.out.print("The Insertion sort "+list);
		long time = System.nanoTime() - startTime;
		System.out.println(" Insertion Sort Execution time: "+time+" ns");
	}
}
