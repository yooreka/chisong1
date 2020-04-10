
public class switch1 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("핸드폰선택(a-갤럭시 b-아이폰 c- 화웨이)");
		final String SAMSUNG = "a";
		final String APPLE = "b";
		final String HWAWEI = "c";
		String phone = sc.nextLine();

		switch (phone) {
		case SAMSUNG:
			System.out.println("갤럭시");
			break;
		case APPLE:
			System.out.println("아이폰");
			break;
		case HWAWEI:
			System.out.println("화웨이");
			break;
		default:
			System.out.println("잘못된 선택");

		}
		
		sc.close();
	}

}
