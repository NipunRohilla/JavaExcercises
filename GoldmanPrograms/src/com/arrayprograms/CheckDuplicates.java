package com.arrayprograms;

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicates {

	public static void main(String[] args) {
		int arr[]={1,2,2,4,5,5,6,7};
		int length=arr.length;
		
		/* First approach by comparing size of set and length of array*/
		Set<Integer> set= new HashSet<>();
		for(int i: arr){
			set.add(i);
		}
		
		if(set.size() == length){
			System.out.println("Array doesn't contain duplicates with length check");
		}else{
			System.out.println("Array contain duplicates with length check");
		}
		
		/* Second approach by adding elements in Set..if already present then returns false*/
	boolean status=	checkDuplicateswithSet(arr);
	if(status){
		System.out.println("Array contain duplicates with set method check");
	}else{
		System.out.println("Doesn't contain duplicates with set method check");
	}
		
	
		
		
}

	private static boolean checkDuplicateswithSet(int[] arr) {
		Set<Integer> set2= new HashSet<>();
		for(int i:arr){
			if(!set2.add(i)){
				return true;
			}
		}
		return false;
	}

}
