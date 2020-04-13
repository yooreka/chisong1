import java.util.Scanner;

public class lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1~45사이의 숫자를 6번 입력 받기

		for (int l = 0; l < 6; l = l + 1) {
			// 1보다 작거나 45보다 큰경우
			System.out.println("1~45숫자 입력 :");
			int lo = sc.nextInt();
			if (lo < 1 || 45 < lo) {
				System.out.println("1~45사이의 숫자를 입력하세요!!");
				l = l - 1;
				break;
			}
			System.out.println(l + "번째:" + lo);

		}
		System.out.println("종료");
	}

}
