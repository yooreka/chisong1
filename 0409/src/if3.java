
public class if3 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("아이디:");
		String id = sc.nextLine();
		System.out.println("비밀번호");
		String ab = sc.nextLine();
		
		if("root".equals(id) && "dbwns".equals(ab)) {
			System.out.println("로그인성공");
		}else { System.out.println("로그인실패");
		
		sc.close();
		
	}
	}
}
