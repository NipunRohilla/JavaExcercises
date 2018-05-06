package com.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentsMarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str[][]={
				{"Bob","87"},
				{"Clark", "64"},
				{"Charlie","22"},
				{"Charlie","100"}
		};
		
		if(findAverage(str) == 70){
			System.out.println("Found the average ");
		}else{
			System.out.println("Haven't found the average");
		}
	}

	private static Integer findAverage(String[][] str) {
		
		HashMap<String,List<String>> hmap = new HashMap<>();
		
		for(String[] s:str){
			
			List<String> list = new ArrayList<>();
			
			if(hmap.get(s[0]) != null){
				list=hmap.get(s[0]);
				list.add(s[1]);
			}else{
				list.add(s[1]);
				hmap.put(s[0], list);	
			}
			
		}
		
	System.out.println(	hmap.values());
	System.out.println(hmap.keySet());
	
	int average=0,sum=0;
	for(List<String> l: hmap.values()){
		if(l.size()>1){
			int value = 0;
			
			for(String str1: l){
				value +=Integer.parseInt(str1);
			}
			sum += value/(l.size());
			
		}else if (l.size() == 1){
			sum += Integer.parseInt(l.get(0));
		}
			
		
	}
	average= sum/hmap.values().size();
	System.out.println("Average of all the marks:: "+ average);
		return average;
	}

}
