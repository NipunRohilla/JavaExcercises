package com.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int arr[] ={18,15,14,5,8,10};
		int high= arr.length;
		QuickSortDemo demo= new QuickSortDemo();
		demo.sort(arr);
//		System.out.println(Arrays.toString(arr));
	}
}
	class QuickSortDemo{
	private  	int arr[];
		private int length;
		
		void sort(int[] arr){
			this.arr=arr;
			length=arr.length;
			quicksort(0,length-1);
			System.out.println(Arrays.toString(arr));
		}
		
	
	
	
	private  void quicksort( int low, int high) {

		int i=low;
		int j=high;
		
		int mid=low+ (high-low)/2;
		int pivot= arr[mid];
		
		while(i<=j){
			if(arr[i] < pivot){
				i++;
			}
			if(arr[j]> pivot){
				j--;
			}
			
			if(i<=j){
				swap(arr,i,j);
				i++;
				j--;
			}
		}	
			if(i<high){
				quicksort(i, high);
			}
			if(j>low){
				quicksort( low, j);
			}
		
	}

	private static void swap(int[] arr,int i, int j) {

		int temp= arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
