package com.stringmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveCharacters {

	public static void main(String[] args) {
		String a = "Cool";
		a = a.replace("o","");
		System.out.println(a + " length of string is: " + a.length());
		
		String[] n = new String[]{"google","microsoft","apple"};
		System.out.println("length" +n.length);
	      final List<String> list =  new ArrayList<String>();
	      
	      Collections.addAll(list, n); 
	      list.remove(n[0]);
	     System.out.println( list.get(0));
	      n = list.toArray(new String[list.size()]);
	      for(String s:n){
	      System.out.println(s);
	      }
	}

}
