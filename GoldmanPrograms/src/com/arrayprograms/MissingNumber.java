package com.arrayprograms;

public class MissingNumber {

	public static void main(String[] args) {
		int arr[]={1,2,3,5,6,7,8,9,10};
		int length= arr.length+1;
		int missingNum= findNumber(arr, length);
		System.out.println("Missing no is: " + missingNum);
	}

	private static int findNumber(int[] arr, int len) {
		int expectedSum = len*(len+1)/2, actualSum=0;
		for(int i:arr){
			actualSum += i;
		}
		return expectedSum-actualSum;
	}

}
