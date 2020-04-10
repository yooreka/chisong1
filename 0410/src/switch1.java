
public class switch1 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("�ڵ�������(a-������ b-������ c- ȭ����)");
		final String SAMSUNG = "a";
		final String APLE = "b";
		final String HWAWEI = "c";
		String phone = sc.nextLine();

		switch (phone) {
		case SAMSUNG:
			System.out.println("������");
			break;
		case APLE:
			System.out.println("������");
			break;
		case HWAWEI:
			System.out.println("ȭ����");
			break;
		default:
			System.out.println("�߸��� ����");

		}
		
		sc.close();
	}

}
