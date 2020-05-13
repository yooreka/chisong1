import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ProcedureCall {

	public static void main(String[] args) {
		try {
			// 1.드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user14", "user14");
			// 메뉴얼Commit으로 변경
			con.setAutoCommit(false);
			// 3.실행 객체 생성
			CallableStatement cstmt = con.prepareCall("{call INSERT_DEPT_PROC(?,?,?)}");
			// 작업을 데이터베이스에 반영
			cstmt.setInt(1, 2);
			cstmt.setString(2, "설계");
			cstmt.setString(3, "독도");
			// 4.실행
			int rownum = cstmt.executeUpdate();

			// 5.결과사용
			if (rownum > 0) {
				System.out.println("데이터삽입성공");
			} else {
				System.out.println("데이터삽입실패");
			}

			con.commit();
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
