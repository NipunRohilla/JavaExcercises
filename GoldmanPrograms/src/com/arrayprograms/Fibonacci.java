package com.arrayprograms;

public class Fibonacci {

	static void reverse()
    {
        String original = "reverse the word";
        String sb = "";

        String[] words = original.split("\\s" );
        for (int i = words.length - 1; i >= 0; i--)
        {
//           sb = sb.concat(words[i]);
//           sb= sb.concat(" ");
        	sb = sb + words[i] + " ";
            
        }
        System.out.println(sb);
        
    }
	
	public static void main(String[] args) {
		
		reverse();
		// TODO Auto-generated method stub
		int n=9;
		int first=0;
		int second=1;
		int sum = 0;
		
		for(int i=2; i<=n;i++){
			sum=first+second;
			first=second;
			second=sum;
			
		}
		System.out.println(sum);
	}

}
