	//Andrew Young
	import java.io.*;
	import java.util.*;

public class HackerRank1 {
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	         
	        int testcases;
	        int userEntries;
	        
	        Scanner sc = new Scanner(System.in);
	        
	        testcases = sc.nextInt();
	        
	        for(int i = 0; i < testcases; i++){
	            userEntries = sc.nextInt();
	            printNum(userEntries);
	            System.out.println(" ");
	        }
	         
	    }
	    
	    public static int printNum(int Max){
	     if(Max > 0){
	            System.out.print(printNum(Max-1) +" ");
	        }
	        return Max + 1;
	    }
	}

