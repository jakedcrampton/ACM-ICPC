import java.util.Scanner;
public class K {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int N = scan.nextInt();
		int Q = scan.nextInt();
		int[] companies = new int[N];
		int count = 0;
		while (count<N) {
			companies[count] = scan.nextInt();
			
			count++;
		}
		
		while (Q > 0) {
			int op = scan.nextInt();
			int op1 = scan.nextInt();
			int op2 = scan.nextInt();
			
			if (op == 1) {
				companies[op1 -1] = op2;
			} else {
				int diff = Math.abs(companies[op1-1] - companies[op2-1]);
				System.out.println(diff);
			}
			
			Q--;
		}
	}
}
