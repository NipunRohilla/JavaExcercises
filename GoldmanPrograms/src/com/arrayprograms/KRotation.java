package com.arrayprograms;

public class KRotation {

	public static void main(String[] args) {

		int arr[]={4,5,1,2,3};
		int index=binaryCount(arr,0,arr.length-1);
		System.out.println(index);
	}

	private static int binaryCount(int[] arr, int i, int j) {
		int low=i, high=j;
		int mid= low+ (high-low)/2;
		
		if(arr[mid+1] < arr[mid]){
			return mid+1;
		} 
		if(arr[mid]<arr[mid-1]){
			return mid;
		}
		if(high < arr[mid]){
			return binaryCount(arr, mid+1, high);
		}else{
			return binaryCount(arr, low, mid-1);
		}
	}

}
