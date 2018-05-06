package com.arrayprograms;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CheckDuplicatesWithHashMap {

	public static void main(String[] args) {
		int arr[]={2,5,8,4,4,5,9,11,11,11,11};
		
		HashMap<Integer,Integer> map = new HashMap<>();

		for(int i:arr){
			Integer count= map.get(i);
			if(count != null){
				map.put(i, ++count);
			}else{
				map.put(i, 1);
			}
		}
		
		Set<Entry<Integer,Integer>> entrySet=map.entrySet();
		for(Entry<Integer, Integer> e :entrySet){
			if(e.getValue() > 1){
				System.out.println("Duplicate element:" + e.getKey() + " and Count is " + e.getValue());
			}
		}
		
		
		}
	}


