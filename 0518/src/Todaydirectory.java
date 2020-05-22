
public class Todaydirectory {

	public static void main(String[] args) {
		String s = System.getProperty("user.dir");
		System.out.println("현재 디렉토리는 " + new java.io.File(s).getName() + " 입니다");
	}

}
