
public class exfirst {

	public static void main(String[] args) {
		java.util.Scanner cs = new java.util.Scanner(System.in);

		System.out.println("����:");

		int score = cs.nextInt();

		System.out.println("sore:" + score);
		// ������ �Է¹ް�

		if (score >= 60) {
			System.out.println("�հ�");
		}

		System.out.println("����");

		cs.close();

	}
}
