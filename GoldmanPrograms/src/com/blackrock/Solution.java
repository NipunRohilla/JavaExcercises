package com.blackrock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static final String PIPE = "\\|";
	
	static int countHoldings(String input){
		// String input =	"VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12"	;
		
		List<String[]> list= new ArrayList<>();
		String[] portfolio= input.split(PIPE);
		for(String s: portfolio){
			String holding[] = s.split(",");
			list.add(holding);
		}
		
		return list.size();
	}
	
	static String prinHoldings(String input) {
	
		// 2Ways:
		// 1 way: To split the string to its very elements.
		List<String[]> list= new ArrayList<>();
		
		// 2nd Way: To split the string just for once based on PIPE only and sort it based on its first index.
		List<String> listStr= new ArrayList<>();
		
		String[] portfolio= input.split(PIPE);
		for(String s: portfolio){
			String holding[] = s.split(",");
			list.add(holding);
			listStr.add(s);
		}
		System.out.println("******");
		for(String[] s:list){
			for(int i=0; i< s.length;i++){
				System.out.print(s[i]+",");
			}
			System.out.print("|");
		}
		System.out.println("\n******");
		
		
		Collections.sort(list, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				
				return o1[0].compareTo(o2[0]);
			}
		});
		
		Collections.sort(listStr, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2){
				return o1.compareTo(o2);
			}
		});
		
		//    [VOD,Vodafone,10],[GOOG,Google,15],[MSFT,Microsoft,12]
		
	//------------------------------------------------------------------------------	
		/*	Method 1:( USING LIST IN THE LOOP)
		 * 
		 * String[] newStr= new String[list.size()];
		int count=0;
		
		for(String[] asset: list){
			String temp="[";
			temp = temp.concat(String.join(",", asset)).concat("]");
			newStr[count]= temp;
			count++;
		}
		
		return String.join(",", newStr);*/
		
	//--------------------------------------------------------------------------------	
		// Method 2: ( USING LIST IN THE LOOP)
	/*	List<String> newList= new ArrayList<>();
		for(String[] asset:list){
			String temp="[";
			temp = temp.concat(String.join(",", asset)).concat("]");
			newList.add(temp);
		}
		
		return String.join(",", newList);*/
		
	//	-------------------------------------------------------------------------------
		// METHOD 3: USING listStr in the loop
		List<String> l= new ArrayList<>();
		for(String s: listStr){
			l.add(s.replaceAll(s, "[".concat(s).concat("]")));
			
		}
		
		return String.join(",", l);
		
	}
	public static void main(String[] args) throws IOException{

		Scanner in= new Scanner(System.in);
		final String fileName = "C:\\Users\\Nipun Rohilla\\Desktop\\Output_File";
		BufferedWriter bw= new BufferedWriter(new FileWriter(fileName));
		int res;
		String _input;
		try{
			System.out.println("***** First input*****");
			_input=in.nextLine();
		}catch(Exception e){
			_input = null;
		}
		
		res= countHoldings(_input);
		System.out.println(prinHoldings(_input));
		
		System.out.println("***** second input*****");
		String _secondInput= in.nextLine();
		System.out.println("****Second output**** \n"+createTransaction(_secondInput));
		bw.write(String.valueOf(res));
		bw.newLine();
		bw.close();
		
	}

	private static String createnew(int a, int b) {
		return "";
		
	}

	static String createTransaction(String _input) {
//String input = "VOD,Vodafone,10|GOOG,Google,15|MSFT,Microsoft,12 : VOD,Vodafone,16|GOOG,Google,12|MSFT,Microsoft,12"	;
		
		
		String[] collectionOfAsset = _input.split(":");
		String[] portfolio = null;
		String[] benchmark = null;
		for(int i=0;i<collectionOfAsset.length;i++){
			portfolio= collectionOfAsset[0].split(PIPE);
			benchmark=collectionOfAsset[1].split(PIPE);
		}
		
		List<String[]> listofAssetsPortfolio= new ArrayList<>();
		for(String portAssets: portfolio){
			String[] asset=portAssets.split(",");
			listofAssetsPortfolio.add(asset);
		}
		
		List<String[]> listofAssetBenchmark= new ArrayList<>();
		for(String benchAssets: benchmark){
			listofAssetBenchmark.add(benchAssets.split(","));
		}
		
		Map<String, List<String>> hmap= new HashMap<>();
//		int count=0;
		for(String[] str: listofAssetsPortfolio){
			
			List<String> tempList= new ArrayList<>();
			
			String key= str[0];
			tempList.add(str[2]);
			hmap.put(key, tempList);
		}
		
		int count=0;
		for(String[] str: listofAssetBenchmark){
		if(hmap.get(str[count]) != null){
			List<String> tempList2 = hmap.get(str[count]);
			tempList2.add(str[count+2]);
			hmap.put(str[count], tempList2);
			}
		}
		
		List<List<String>> listOftransactions= new ArrayList<>();
		
		Set<Map.Entry<String,List<String>>> set=hmap.entrySet();
		for(Map.Entry<String,List<String>> entry: set){		
			List<String> list=entry.getValue();
			List<String> singletransaction= new ArrayList<String>();
			
			for(int i=0;i<list.size();i++){
				int i1= Integer.parseInt(list.get(i));
				int i2= Integer.parseInt(list.get(i+1));
				if(i1 < i2){
					int val= Integer.parseInt(list.get(i+1)) - Integer.parseInt(list.get(i));								      
					String s1=entry.getKey();
					
					singletransaction.add("BUY");
					singletransaction.add(s1);
					DecimalFormat format = new DecimalFormat("0.00"); 
					singletransaction.add(format.format(val));
					
					listOftransactions.add(singletransaction);
					
				}else if(Integer.parseInt(list.get(i)) > Integer.parseInt(list.get(i+1))){
					int val= Integer.parseInt(list.get(i)) - Integer.parseInt(list.get(i+1));
					String s1=entry.getKey();
					
					singletransaction.add("SELL");
					singletransaction.add(s1);
					DecimalFormat format = new DecimalFormat("0.00"); 
					singletransaction.add(format.format(val));
					
					listOftransactions.add(singletransaction);
				}
			}
		}
		
		Collections.sort(listOftransactions, new Comparator<List<String>>(){
			public int compare(List<String> l1, List<String> l2){
				int count=0;
				return l1.get(count+1).compareTo(l2.get(count+1));					
				}			
			});
		List<String> finalList= new ArrayList<>();
		
		for(List<String> l: listOftransactions){
			finalList.add("["+String.join(",", l)+"]");
		}
		return String.join(",", finalList);
	}

}
