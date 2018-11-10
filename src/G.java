import java.util.Scanner;
public class G {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<n;i++) {
			int t=scan.nextInt();
			System.out.println(fact(t)%10);
		}
	}
	static int fact(int n) {
		if(n==1||n==0)return 1;
		else return n*fact(n-1);
		
	}
}
