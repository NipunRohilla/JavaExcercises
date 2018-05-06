package com.arrayprograms;

public class Find2Smallest {

	public static void main(String[] args) {

		int arr[]={2,8,6,7,10};
		find2Smallest(arr);
	}

	private static void find2Smallest(int[] arr) {

		int firstSmallest=Integer.MAX_VALUE;
		int secondSmallest=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++){
			if(arr[i] < firstSmallest){
				secondSmallest=firstSmallest;
				firstSmallest=arr[i];
			}else if(arr[i] < secondSmallest &&  firstSmallest != arr[i] ){
				secondSmallest= arr[i];
			}
		}
		System.out.println("Smallest element is: " + firstSmallest + "\n Second smallest element is: " + secondSmallest);
	}

}
