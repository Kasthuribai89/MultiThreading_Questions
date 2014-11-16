package com.sukanya.Thread.Sorting;

import java.util.LinkedList;

public class BubbleSort implements Runnable
{
	int a[];
	public BubbleSort(int a[])
	{
		this.a = a;
	}
	public void run()
	{
		long startTime = System.nanoTime();
		LinkedList<Integer> list = new LinkedList();
		int length = a.length;
		
		for(int i=0;i<length;i++)
		{
			for(int j=1;j<length;j++)
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
		
		System.out.print("The BubbleSort "+list);
		long time = System.nanoTime() - startTime;
		System.out.println(" BubbleSort execution time: " + time + " ns");
	}

}
