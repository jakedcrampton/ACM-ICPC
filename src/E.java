import java.util.Scanner;
public class E {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n=scan.nextInt();
		int[] x=new int[n];
		int[] y=new int[n];
		int[] r=new int[n];
		for(int i=0;i<n;i++) {
			x[i]=scan.nextInt();
			y[i]=scan.nextInt();
			r[i]=scan.nextInt();
		}
		double[][] distance=new double[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				distance[i][j]=dist(x[i],y[i],x[j],y[j])-(r[i]+r[j]);
			}
		}
		boolean[] connected=new boolean[n];
		int bars=0;
		for(int i=0;i<n;i++) {
			if(!connected[i]) {
				int index=0;
				double min=0;
				for(int j=0;j<n;j++) {
					if(distance[i][j]<0.001) {
						connected[i]=true;
						index=j;
						break;
					}
				}
			}
		}
	}
	public static double dist(int x1,int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}
