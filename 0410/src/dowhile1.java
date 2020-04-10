
public class dowhile1 {

	public static void main(String[] args) {
		int [ ] ar = {30, 40, 20, 17, 76, 65};
		
		int idx = 0;
		int sum = 0;
		
		do {
			        sum = sum + ar[idx];
			        idx = idx + 1;
		}
	while(idx < 6);
	System.out.println("ÇÕ°è:" + sum);
	double avg = (int)((sum / 6.0)*10 + 0.5);
	System.out.println("Æò±Õ:" + avg/10);
	}
	
	
	

}
