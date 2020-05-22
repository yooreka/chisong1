import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CrimeDAO {
	// 클래스가 로드될 때 1번만 수행되는 코드
	// 제일 먼저 실행되는 코드
	static {
		// MySQL 드라이버 클래스 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.err.println("드라이버 클래스 로드 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// 싱글톤 패턴(인스턴스를 1개만 생성할 수 있도록 하는 패턴)을 위한코드
	// Back- End Programmer를 주력으로 하고자하는경웬는 객체지향 디자인 패턴을학습
	// 생성자가 private 이므로 외부에서 인스턴스 생성을 모샇ㅁ
	private CrimeDAO() {
	}

	// 변수를 1개만 생성할 수 있도록 선언
	private static CrimeDAO crimeDAO;

	// 외부에서 생성된 인스턴스를 사용할 수 있도록 리턴해주는 메소드
	public static CrimeDAO sharedInstance() {
		// static 변수이므로 null을 대입하지 않는이상
		// 맨처음에만 null이고 이후에는 null이 될 수 없음
		if (crimeDAO == null) {
			crimeDAO = new CrimeDAO();
		}
		return crimeDAO;
	}
	// JAVA server 개발에는 Spring을 많이 사용하는데 Spring이 자동으로
	// 클래스를 Singleton Pattern으로 디자인해줌

	// 여러 메소드에서 공통으로 사용할 변수
	// java.sql 패키지의 클래스를 import
	private Connection con;
	private PreparedStatement pstmt;

	// 데이터베이스 접속을 위한 메소드
	public void connect() {
		try {
			// 데이터베이스 연결
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sample" + "?useUnicode=true&characterEncoding=utf8", "root",
					"dbsguswjd132");
			System.out.println("데이터베이스 접속 성공");
		} catch (Exception e) {
			System.err.println("데이터 베이스 로드 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	// 데이터베이스 연결 객체를 정리해주는 메소드
	public void close() {
		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			System.err.println("데이터 베이스 해제 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	// 1.전체보기를 위한 메소드
	// 조회는 몇 열의 데이터를 몇 행으로 조회하는지 : 리턴타임
	// where 절이 있는지 확인 : 파라미터
	// select * from Crime
	public List<Crime> allcrime() {

		List<Crime> list = new ArrayList<Crime>();
		// 데이터 베이스 연결
		connect();

		try {
			// SQL실행객체 생성
			pstmt = con.prepareStatement("select * from Crime");
			// SQL실행
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Crime crime = new Crime();
				crime.setCategorize(rs.getString("categorize"));
				crime.setAllcrime(rs.getInt("allcrime"));

				crime.setPersent(rs.getDouble("persent"));
				// list에추가
				list.add(crime);
			}

			rs.close();
			//현재날짜를 포함한 파일 경로를 만들기
			Date today = new Date(System.currentTimeMillis());
			//현재 디렉토리에 오늘날짜.log 문자열생성
			String filepath = "./" + today.toString() + ".log";
			//try()안에서 만들면 close를 호출하지 않아도됨
			//true 를 대입한것은 없으면 만들지만 있으면 데이터를 뒤에 추가
			try(PrintWriter pw = new PrintWriter(new FileOutputStream(filepath, true))){
				//유틸은아무것도안넣으면 오늘날짜
				java.util.Date date = new java.util.Date();
				pw.println(date.toString() + "\t" + "전체보기" + "\n");
			    pw.flush();
			}

			Date curdate = new Date(System.currentTimeMillis());
			String filename = "./" + curdate.toString() + ".dat";
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))){
			Log log = new Log();
			log.setDate(new java.util.Date());
			log.setTask("전체보기");
			oos.writeObject(log);
			oos.flush();
			}
		} catch (Exception e) {
			System.err.println("전체데이터 가져오기 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		// 데이터베이스 연결 해제
		close();

		// 데이터가 없을 때는 List의 size가 0
		return list;

	}

	// 2.상세보기를 위한 메소드
	// select * from 테이블이름 where 기본키 = ?
	public Crime getCrime(String categorize) {

		// 하나의 행이 리턴되는 경우는 인스턴스 데이터를 가져왔을 떄 생성
		Crime crime = null;
		connect();

		try {
			// select 구문의 경우 where 절이 있으면 데이터를 매개변수로 받아서 바인딩을 해야 합니다.
			pstmt = con.prepareStatement("select * from crime where categorize = ?");

			pstmt.setString(1, categorize);
			// SQL 실행
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// 리턴할 데이터의 인스턴스 생성
				crime = new Crime();
				crime.setCategorize(rs.getString("categorize"));
				crime.setAllcrime(rs.getInt("allcrime"));
				crime.setMentalcrime(rs.getInt("mentalcrime"));
				crime.setPersent(rs.getDouble("persent"));
			}

		} catch (Exception e) {
			System.out.println("상세보기 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		close();
		return crime;

	}

//3데이터를 삽입하는 메소드
	// insert into 테이블이름(컬럼이름나열)
	// values(값을나열)
	// 특별한 경우가 아니면 컬럼은 2개이상
	// select를 제외한 모든 SQL의 실행은 영양받은 행의 개수를 리턴
	public int insertCrime(Crime crime) {
		//Serializable 된 데이터 읽어오기
		Date today = new Date(System.currentTimeMillis());
		String filename = "./" + today.toString() + ".dat";
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Log log = (Log)ois.readObject();
			System.out.println(log);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
		
		// 여기서 -1은 의미없는 값으로 삽입 실패를 의미하는 값
		// 어떤 음수라도 가능 0은 조심
		int result = -1;
		// 데이터 베이스 연결
		connect();

		try {
			// SQL 실행 객체 생성 - SQL 생성
			// 값을 대입하는 곳은 ? 로 설정
			// 값을 대입하는 곳 중에서 고정된 값이면 고정된 값을 이용
			pstmt = con.prepareStatement(
					"insert into crime(" + "categorize, allcrime, mentalcrime, persent) " + "values(?,?,?,?)");
			// 비어있는 곳에 값을 채움 = 바인딩
			pstmt.setString(1, crime.getCategorize());
			pstmt.setInt(2, crime.getAllcrime());
			pstmt.setInt(3, crime.getMentalcrime());
			pstmt.setDouble(4, crime.getPersent());
			// SQL실행
			result = pstmt.executeUpdate();
			//현재날짜를 포함한 파일 경로를 만들기
			Date today1 = new Date(System.currentTimeMillis());
			//현재 디렉토리에 오늘날짜.log 문자열생성
			String filepath = "./" + today1.toString() + ".log";
			//try()안에서 만들면 close를 호출하지 않아도됨
			//true 를 대입한것은 없으면 만들지만 있으면 데이터를 뒤에 추가
			try(PrintWriter pw = new PrintWriter(new FileOutputStream(filepath, true))){
				//유틸은아무것도안넣으면 오늘날짜
				java.util.Date date = new java.util.Date();
				pw.println(date.toString() + "\t" + "삽입" + "\n");
			    pw.flush();
			}
	
		
		
		
		} catch (Exception e) {
			// 자신이 알아볼 수 있는 예외 메시지를 출력
			System.out.println("데이터 삽입 실패");
			// 프로그램이 주는 예외 메시지를 출력
			System.out.println(e.getMessage());
			// 위의 2개 작업은 파일이나 데이터베이스에 기록하고 주석처리

			// 예외발생지점을 찾기위한 작업
			e.printStackTrace();
		}

		// 데이터베이스 연결 해제
		close();
		return result;

	}

	// crime테이블에서 가장큰 num을 찾아오는 메소드
	public int maxNum() {
		int result = 0;
		connect();
		try {
			pstmt = con.prepareStatement("select max(num) from Crime");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("max(num)");

			}

		} catch (Exception e) {
			System.out.println("실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;

	}

	// 데이터를 삭제하는 메소드
	// delete from 테이블이름 where 기본키=?
	// 리턴타입은 정수
	// 매개변수는 기본키
	public int deleteCrime(String categorize) {
		System.out.println(categorize);
		int result = -1;
		connect();
		// 삽입, 삭제, 갱신은 sql을 생성 부분과 바인딩 하는 부분만 변경
		try {
			pstmt = con.prepareStatement("delete from crime where categorize = ?");
			// 데이터 바인딩
			pstmt.setString(1, categorize);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("데이터 삭제실패");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		close();
		return result;
	}

//데이터 수정을 위한 메소드
	public int updateCrime(Crime crime) {
		int result = -1;
		connect();
		// 삽입, 삭제, 갱신은 sql을 생성 부분과 바인딩 하는 부분만 변경
		try {
			pstmt = con.prepareStatement("update crime" +" set allcrime=?,mentalcrime=?,persent=? " + "where categorize=?");
			pstmt.setInt(1, crime.getAllcrime());
			pstmt.setInt(2, crime.getMentalcrime());
			pstmt.setDouble(3, crime.getPersent());
			pstmt.setString(4, crime.getCategorize());
			result = pstmt.executeUpdate();

			// 데이터 바인딩

		} catch (Exception e) {
			System.out.println("데이터 삭제실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;

	}
	//전체 데이터 개수를 구하는메소드
	//select count(*) from crime
	public int getCount(){
	int result = -1;
	connect();
	try {
		pstmt = con.prepareStatement( "select count(*) from crime");
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			result = rs.getInt("count(*)");
		}
		
	}catch(Exception e) {
		System.out.println("데이터 개수 새기 실패");
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	    
	}
	close();
	return result;

	}
  public List<Crime> pageCrime(int pageno, int pagecnt){
	  List<Crime> list = new ArrayList<Crime>();
	  connect();
	  try {
		  pstmt = con.prepareStatement("select * " + "from crime " + "limit ?, ?");
		  pstmt.setInt(1, pagecnt *(pageno-1));
		  pstmt.setInt(2,  pagecnt);
		  
		  ResultSet rs = pstmt.executeQuery();
		  while(rs.next()) {
			  Crime crime = new Crime();
			  crime.setCategorize(rs.getString("categorize"));
			  crime.setAllcrime(rs.getInt("allcrime"));
		  list.add(crime);
		  }
	  }catch(Exception e) {
		  System.out.println("데이터 검색 실패");
		 System.out.println(e.getMessage());
		 e.printStackTrace();
	  }
	close();
	  return list;
  
  }
}

