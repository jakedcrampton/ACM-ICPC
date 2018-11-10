//Team 15 Runtime Exception
import java.util.*;
public class B {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n=scan.nextInt();
		Integer[] Gm = {0,2,3,5,7,9,10};
		String[] Gma = {"A","B","C","D","E","F#","G"};
		Integer[] Cm = {0,2,3,5,7,8,10};
		String[] Cma = {"A","B","C","D","E","F","G"};
		Integer[] Ebm = {1,3,5,6,8,10,11};
		String[] Ebma = {"Bb","C","D","Eb","F","G","Ab"};
		Integer[] Fsm = {0,2,4,5,7,9,11};
		String[] Fsma = {"A","B","C#","D","E","F#","G#"};
		Integer[] Gmi = {0,1,3,5,6,8,10};
		String[] Gmin = {"A","Bb","C","D","Eb","F","G"};
		String[] keys = {"G major","C major","Eb major","F# minor","G minor"};
		ArrayList<Double> freqs = new ArrayList<>();
		for(int i = 0; i<12; i++) {
			freqs.add(440*Math.pow(2, (double)i/12));
		}
		boolean flag = false;
		ArrayList<Integer> input = new ArrayList<>();
		for(int i=0;i<n;i++) {
			double f=scan.nextDouble();
			for(int j = 0; j< freqs.size(); j++) {
				if(Math.abs((f+0.0001)%freqs.get(j))<=.0002001 || (freqs.get(j)%(f-.0001))<=.0002001) {
					input.add(j);
					break;
				}
			}
			if(input.size()<=i) {
				flag = true;
			}
		}
		if(flag) {
			System.out.println("cannot determine key");
			return;
		}
		boolean[] key = new boolean[5];
		if(Arrays.asList(Gm).containsAll((input))) {
			key[0] = true;
		}
		if(Arrays.asList(Cm).containsAll(input)) {
			key[1] = true;
		}
		if(Arrays.asList(Ebm).containsAll(input)) {
			key[2] = true;
		}
		if(Arrays.asList(Fsm).containsAll(input)) {
			key[3] = true;
		}
		if(Arrays.asList(Gmi).containsAll(input)) {
			key[4] = true;
		}
		int found = -1;
		for(int i = 0; i<5; i++) {
			if(key[i]) {
				if(found!=-1) {
					System.out.println("cannot determine key");
					return;
				}
				found = i;
			}
		}
		if(found==-1) {
			System.out.println("cannot determine key");
			return;
		}
		System.out.println(keys[found]);
		if(found == 0) {
			for(int i = 0; i<n; i++) {
				System.out.println(Gma[Arrays.binarySearch(Gm, input.get(i))]);
			}
		}
		if(found == 1) {
			for(int i = 0; i<n; i++) {
				System.out.println(Cma[Arrays.binarySearch(Cm, input.get(i))]);
			}
		}
		if(found == 2) {
			for(int i = 0; i<n; i++) {
				System.out.println(Ebma[Arrays.binarySearch(Ebm, input.get(i))]);
			}
		}
		if(found == 3) {
			for(int i = 0; i<n; i++) {
				System.out.println(Fsma[Arrays.binarySearch(Fsm, input.get(i))]);
			}
		}
		if(found == 4) {
			for(int i = 0; i<n; i++) {
				System.out.println(Gmi[Arrays.binarySearch(Gmin, input.get(i))]);
			}
		}
	}
}
