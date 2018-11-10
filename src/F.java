import java.util.*;
public class F {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int T=scan.nextInt();
		for(int i=0;i<T;i++) {
			ArrayList<Shipment> ships=new ArrayList<Shipment>();
			int N=scan.nextInt();
			for(int j=0;j<N;j++) {
				String name=scan.next();
				int num=scan.nextInt();
				boolean contains=false;
				int index=-1;
				for(int k=0;k<ships.size();k++) {
					if(ships.get(k).name.equals(name)) {
						contains=true;
						index=k;
						break;
					}
				}
				if(!contains) {
					ships.add(new Shipment(name,num));
				}
				else {
					ships.get(index).num+=num;
				}
			}
			System.out.println(ships.size());
			Shipment[] ships2=new Shipment[ships.size()];
			for(int k=0;k<ships.size();k++)
				ships2[k]=ships.get(k);
			Arrays.sort(ships2);
			for(int k=0;k<ships2.length;k++)
				System.out.println(ships2[k].name+" "+ships2[k].num);
		}
	}
}
class Shipment implements Comparable<Shipment>{
	String name;
	Integer num;
	public Shipment() {}
	public Shipment(String name) {
		this.name=name;
	}
	public Shipment(String name, Integer num) {
		this.name=name;
		this.num=num;
	}
	public int compareTo(Shipment s) {
		if(s.num<this.num) {
			return -1;
		}
		else if(this.num<s.num) {
			return 1;
		}
		else {
			return name.compareTo(s.name);
		}
	}
	
}