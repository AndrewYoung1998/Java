
public class SumofNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(SumofNumbers(4));

	}
	public static int SumofNumbers(int Num) {
		if(Num > 0) {
			return SumofNumbers(Num-1)+Num;
		}else {
			return 0;
		}
	}
}
