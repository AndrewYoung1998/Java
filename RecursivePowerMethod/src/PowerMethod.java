import java.io.*;
import java.util.*;
public class PowerMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int number;
        int power;
        
        Scanner sc = new Scanner(System.in);
        
        number = sc.nextInt();
        power = sc.nextInt();
        System.out.println("Number: " +number);
        System.out.println("Power: " +power);
		System.out.println(exponent(number,power));
	}
	
	public static int exponent(int Num,int exp) {
		if(exp > 1) {
			return exponent(Num, exp-1)*Num;
		}else {
			return Num;
		}
	}

}
