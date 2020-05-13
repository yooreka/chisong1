import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DEPTinsert {

	public static void main(String[] args) {

		try {
			// 1.드라이버 클래스 로드 - 1번만 수행
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user14", "user14");
			System.out.println("접속 성공");
			// 3.sql실행 객체 생성
			
			PreparedStatement pstmt = con.prepareStatement("insert into dept(deptno, dname, loc) " + "values(?,?,?)");
			pstmt.setInt(1, 81);
			pstmt.setString(2, "분석");
			pstmt.setString(3, "의정부");
	
			
			
			// 4.SQL 실행
			int rownum = pstmt.executeUpdate();
			// 5.결과 사용 삽입은 성공한경우 1이상의 정수가 리턴
			if (rownum >= 1) {
				System.out.println("데이터 삽입 성공");
			} else {
				System.out.println("데이터 삽입 실패");
			}
			// 6.사용이 끝난 객체 정리
			pstmt.close();
			con.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
