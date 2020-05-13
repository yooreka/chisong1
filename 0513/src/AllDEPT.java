import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllDEPT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 1.드라이버 클래스 로드 - 1번만 수행
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user14", "user14");
			System.out.println("접속 성공");
			// 3.sql실행 객체 생성
			
			PreparedStatement pstmt = con.prepareStatement("select deptno, dname, loc " + " from dept");
	        
			// 4.SQL 실행
	        ResultSet rs = pstmt.executeQuery();
			
			// 5.결과 사용 
			if (rs.next()) {
				do {
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");
					System.out.println(deptno + "\t" + dname  + "\t" + loc);
				}while(rs.next());
			} else {
				System.out.println("조회된 데이터 없음");
			}
			// 6.사용이 끝난 객체 정리
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
