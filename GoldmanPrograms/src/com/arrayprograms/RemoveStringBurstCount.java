package com.arrayprograms;

import java.util.Arrays;

public class RemoveStringBurstCount {
	
	public static void main(String[] args) {
		int arr[]= {1,1,2,2,3,4,5};
		
			removeDuplicates(arr);
		}
		
	
	public static void removeDuplicates(int[] arr) {
		Arrays.sort(arr);
		int result[]= new int[arr.length];
		
		int previous=arr[0];
		result[0]=previous;
		
		for(int i=1;i< arr.length;i++){
		if(arr[i] != previous){
			result[i]= arr[i];
		}	
		previous= arr[i];
		
		
		}
		System.out.println(Arrays.toString(result));
	}
}
