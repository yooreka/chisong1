
public class matrix3 {

	public static void main(String[] args) {

		int[]ar = new int[20];
		//1에서 20까지 숫자로 배열의 값을 대입
		for(int i = 0; i<20; i = i + 1) {
			ar[i] = i+1;
		}
		//데이터출력
		//한줄에 5개 씩 출력
		for(int i = 0; i<20; i = i + 1) {
			System.out.printf("%3d\t", ar[i]);
		if(i % 5 == 4) {
			System.out.printf("\n");
		}
		}
		
	}

}
