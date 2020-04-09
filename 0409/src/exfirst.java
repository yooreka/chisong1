
public class exfirst {

	public static void main(String[] args) {
		java.util.Scanner cs = new java.util.Scanner(System.in);

		System.out.println("점수:");

		int score = cs.nextInt();

		System.out.println("score:" + score);
		// 점수를 입력받고

		if (score >= 60) {
			System.out.println("합격");
		}

		System.out.println("종료");

		cs.close();

	}
}
