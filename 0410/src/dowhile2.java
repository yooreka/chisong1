
public class dowhile2 {

	public static void main(String[] args) {
		int[] ar = { 700, 600, 500, 430 };

		int idx = 0;
		int sum = 0;

		do {
			sum = sum + ar[idx];

			idx = idx + 1;

		} while (idx < 4);

		System.out.println("합계:" + sum);

		int avg = sum / 4;

		System.out.println("평균:" + avg);

	 double imsi = avg/100.0;
	 
	 imsi = (int)(imsi + 0.5);
	 avg = (int)imsi * 100;
	 
	 System.out.println("평균" + avg);

	}

}
