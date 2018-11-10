import java.util.*;
public class A {
	static double x;
	static double y;
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n =scan.nextInt();
		int order;
		for(int i=0;i<n;i++) {
			x=scan.nextInt();
			y=scan.nextInt();
			if(y==x) {
				System.out.println(0);
				continue;
			}
			else if(x<y) {
				//Math.lo
				order=(int)(Math.log(y)/Math.log(2))+1;
				if(x>Math.pow(2, order-1)-1)order++;
			}else {
				order=(int)(Math.log(x)/Math.log(2))+1;
				if(y>Math.pow(2, order-1)-1)order++;
			}
			//System.out.println(order);
			x=x+0.5;
			y=y+0.5;
			System.out.println(next(order,0,0.25,0.25));
		}
	}
	static int next(int order,int curRot, double cx, double cy) {
		if(order==0) {
			return curRot;
		}
		int nextRot=-1;
		double cx2=-1;
		double cy2=-1;
		boolean in=false;
		double xdiff = Math.abs(x-cx)/Math.pow(2, order-1);
		double ydiff = Math.abs(y-cy)/Math.pow(2, order-1);
		//System.out.printf("xdiff:%f ydiff:%f\n",xdiff,ydiff);
		//generalized way to set newRot
		if (ydiff < 2.0/4 && xdiff < 4.0/4 || ydiff < 4.0/4 && xdiff < 2.0/4) {
			nextRot = curRot;
			in = false;
		} else if (ydiff < 2.0/4 || xdiff > 6.0/4) {
			switch (curRot) {
				case 0 : nextRot = 3; break;
				case 1 : nextRot = 2; break;
				case 2 : nextRot = 1; break; 
				case 3 : nextRot = 0; break;
			}
		} else if (ydiff > 6.0/4 || xdiff < 2.0/4) {
			//same as previous section, not sure if these should be different
			switch (curRot) {
				case 0 : nextRot = 3; break;
				case 1 : nextRot = 2; break;
				case 2 : nextRot = 1; break; 
				case 3 : nextRot = 0; break;
			}
		} else {
			nextRot = curRot;
			in = true;
		}
		//System.out.printf("Cur:%d Next:%d\n",curRot,nextRot);
		//set new centers
		switch (curRot) {
		case 0:
			switch (nextRot) {
				case 0 : 
					if (in) {
						cx2=cx; cy2=cy;
					}else {
						cx2=cx+.25*Math.pow(2, order); 
						cy2=cy+.25*Math.pow(2, order); 
					}
					break;
				case 1 : cx2=cx; cy2=cy+Math.pow(2, order); break;
				case 3 : cx2=cx+Math.pow(2, order); cy2=cy; break;
			}
			break;
		case 1:
			switch (nextRot) {
			case 0 : cx2=cx;cy2=cy-Math.pow(2, order);break;
			case 1 : 
				if (in) {
					cx2=cx; cy2=cy;
				}else {
					cx2=cx+.25*Math.pow(2, order); 
					cy2=cy-.25*Math.pow(2, order); 
				}
				break;
			case 2 : cx2=cx+Math.pow(2, order); cy2=cy; break;
			}
		break;
		case 2:
			switch (nextRot) {
			case 0 : 
				if (in) {
					cx2=cx; cy2=cy;
				}else {
					cx2=cx+.25*Math.pow(2, order); 
					cy2=cy+.25*Math.pow(2, order); 
				}
				break;
			case 1 : cx2=cx; cy2=cy+Math.pow(2, order); break;
			case 3 : cx2=cx+Math.pow(2, order); cy2=cy; break;
			}
		break;
		case 3 :
			switch (nextRot) {
			case 2 : 
				if (in) {
					cx2=cx; cy2=cy;
				}else {
					cx2=cx-.25*Math.pow(2, order); 
					cy2=cy-.25*Math.pow(2, order); 
				}
				break;
			case 3 : cx2=cx; cy2=cy-Math.pow(2, order); break;
			case 1 : cx2=cx-Math.pow(2, order); cy2=cy; break;
			}
		break;
		}
		//System.out.printf("(cx2,cy2):(%f,%f)\n",cx2,cy2);
		return next(order-1,nextRot,cx2,cy2);
	}
}
