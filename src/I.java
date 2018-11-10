import java.util.*;

public class I {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		ArrayList<Die> Uniques = new ArrayList<Die>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < T; i++) {
			int[] dice = new int[6];
			for(int j = 0; j<6; j++) {
				dice[j] = scan.nextInt();
			}
			Die d = new Die(dice);
			if(Uniques.contains(d)) {
				num.set(Uniques.indexOf(d),num.get(Uniques.indexOf(d))+1);
			}
			else {
				Uniques.add(d);
				num.add(0);
			}
		}

		int max = 0;
		for(int k = 0; k<num.size();k++) {
			if(num.get(k)>max);
			max=num.get(k);
		}
		System.out.println(max);
	}
}

class Die implements Comparable<Die> {
	int[] die;

	public Die() {
	}

	public Die(int[] in) {
		die = new int[6];
		for (int i = 0; i < 6; i++) {
			die[i] = in[i];
		}
	}

	public int compareTo(Die d) {
		if(Arrays.equals(die, d.die)) {
			return 0;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				d = d.turn();
				if(Arrays.equals(die, d.die)) {
					return 0;
				}
			}
			d=d.yaw();
			if(Arrays.equals(die, d.die)) {
				return 0;
			}
		}
		for (int j = 0; j < 3; j++) {
			d = d.turn();
			if(Arrays.equals(die, d.die)) {
				return 0;
			}
		}
		d=d.flip();
		if(Arrays.equals(die, d.die)) {
			return 0;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				d = d.turn();
				if(Arrays.equals(die, d.die)) {
					return 0;
				}
			}
			d=d.yaw();
			if(Arrays.equals(die, d.die)) {
				return 0;
			}
		}
		for (int j = 0; j < 3; j++) {
			d = d.turn();
			if(Arrays.equals(die, d.die)) {
				return 0;
			}
		}
		return -1;
	}

	public Die turn() {
		int[] thing = { die[0], die[1], die[4], die[5], die[3], die[4] };
		Die out = new Die(thing);
		return out;
	}

	public Die yaw() {
		int[] thing = { die[4], die[5], die[2], die[3], die[1], die[0] };
		Die out = new Die(thing);
		return out;
	}

	public Die flip() {
		int[] thing = { die[5], die[4], die[1], die[0], die[2], die[3] };
		Die out = new Die(thing);
		return out;
	}
}