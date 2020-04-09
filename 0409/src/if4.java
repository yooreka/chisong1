
public class if4 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("점수");
		int a = sc.nextInt();
		sc.close();
		if (a >=80 && a <= 100) {
			System.out.println("우수");

		} else if (a>= 60 && a<= 79) {
			System.out.println("보통");
		} else if (a>= 0 && a <= 59) {
			System.out.println("노력");

		} else {
			System.out.println("잘못된점수");
		}
	}
}