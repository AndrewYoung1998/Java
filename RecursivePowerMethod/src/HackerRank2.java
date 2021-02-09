	//Andrew Young
	import java.io.*;
	import java.util.*;

public class HackerRank2 {

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
	        return printNum(Max, 1);
	        
	    }
	    
	    public static int printNum(int Max, int current){
	     if(Max >= current){
	            System.out.print(printNum(Max,current+1) +" ");
	        }
	        return current - 1;
	    }

}
