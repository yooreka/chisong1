
public class if4 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("����");
		int a = sc.nextInt();
		sc.close();
		if (a >=80 && a <= 100) {
			System.out.println("���");

		} else if (a>= 60 && a<= 79) {
			System.out.println("����");
		} else if (a>= 0 && a <= 59) {
			System.out.println("���");

		} else {
			System.out.println("�߸�������");
		}
	}
}