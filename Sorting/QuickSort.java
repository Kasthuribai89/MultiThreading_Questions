package com.sukanya.Thread.Sorting;

import java.util.LinkedList;

public class QuickSort implements Runnable
{
	int a[];
	public QuickSort(int a[])
	{
		this.a = a;
		
	}
	public void run()
	{
		final double quicksort_time;
		long startTime = System.nanoTime();
		LinkedList<Integer> list = new LinkedList();
		
		int length = a.length;
		quickSort(a,0,length-1);
		for(int i=0;i<length;i++)
		{
			list.add(a[i]);
		}
		
		System.out.print("The quick Sort "+list);
		long time = System.nanoTime() - startTime;
		quicksort_time = time;
		System.out.println(" Quick Sort Execution time: "+time+" ns");
	}
	
	public void quickSort(int a[],int low,int high)
	{
		int i = low;
		int j = high;
		int mid = low + (high - low)/2;
		
		while(i <= j)
		{
			while(a[i] < a[mid])
			{
				i++;
			}
			while(a[j] > a[mid])
			{
				j--;
			}
			
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		
		if(low < j)
		{
			quickSort(a,low,j);
		}
		
		if(i < high)
		{
			quickSort(a,i,high);
		}
	}
}
