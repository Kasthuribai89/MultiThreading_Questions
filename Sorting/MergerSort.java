package com.sukanya.Thread.Sorting;

import java.util.LinkedList;

public class MergerSort implements Runnable
{
	int a[];
	
	public MergerSort(int a[])
	{
		this.a = a;
	}
	public void run()
	{
		final double MergerSort_time;
		long startTime = System.nanoTime();
		LinkedList<Integer> list = new LinkedList();
		int length = a.length;
		mergerSort(0,a.length-1);
		
		for(int i=0;i<length;i++)
		{
			list.add(a[i]);
		}
		
		System.out.print("The Merge Sort "+list);
		long time = System.nanoTime() - startTime;
		MergerSort_time = time;
		System.out.println(" Merger Sort Execution time: "+time+" ns");
	}
	
	public void mergerSort(int low,int high)
	{
		if(low < high)
		{
			int mid = low + (high - low)/2;
			mergerSort(low,mid-1);
			mergerSort(mid+1,high);
			merge(low,mid,high);
		}
	}
	
	public void merge(int low,int mid,int high)
	{
		int[] helper = new int[a.length];
		for(int i=low;i<=high;i++)
		{
			helper[i] = a[i];
		}
		
		int i= low;
		int j = mid+1;
		int k = low;
		
		while(i <= mid && j <= high)
		{
			if(helper[i] <= helper[j])
			{
				a[k] = helper[i]; 
				i++;
				k++;
			}
			else
			{
				a[k] = helper[j];
				j++;
				k++;
			}
		}
		
		while(i <= mid)
		{
			a[k] = helper[i];
			i++;
			k++;
		}
	}
}
