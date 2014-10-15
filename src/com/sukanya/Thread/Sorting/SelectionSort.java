package com.sukanya.Thread.Sorting;

import java.util.LinkedList;

public class SelectionSort implements Runnable
{
	int a[];
	
	public SelectionSort(int a[])
	{
		this.a = a;
	}
	public void run()
	{
		long startTime = System.nanoTime();
		LinkedList<Integer> list = new LinkedList();
		int length = a.length;
		
		for(int i=0;i<length-1;i++)
		{
			int index = i;
			for(int j=i+1;j<length;j++)
				if(a[j] < a[index])
					index = j;
			
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
		}
		
		for(int i=0;i<length;i++)
		{
			list.add(a[i]);
		}
		
		System.out.print("The selection sort "+list+" ");
		long time = System.nanoTime() - startTime;
		System.out.println(" Selection Sort Execution time: "+time+" ns");
		
	}
}
