
public class MySQLDriverLoad {
/*
  *실행을 위한 메소드 입니다 @param args
  *이렇게 만들면 클래스 주석입니다
  */
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
		}catch(Exception e) {
			System.out.println("드라이버 로드 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
