
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//데이터베이스 연동 메소드를 소유한 클래스
public class TeamDAO {
	// 싱글톤 패턴 디자인 = 객체를 1개만 생성할 수 있도록 만든 패턴
	// 외부에서 생성할 수 없도록 생성자를 private로
	private TeamDAO() {
	}

	// 만들어진 객체의 참조를 저장하기 위한 변수
	private static TeamDAO teamDAO = null;

	// 객체가 없으면 만들어서 리턴하고
	// 있으면 있는 것을 리턴하도록 하는 객체 사용을 위한 메소드
	public static TeamDAO sharedInstance() {
		if (teamDAO == null) {
			teamDAO = new TeamDAO();
		}
		return teamDAO;

	}
 //메소드 들에서 공통으로 사용할 변수
	private Connection con;
	private PreparedStatement pstmt;
	
	//데이터베이스 연결메소드
	//이제 만들어놓으면 커넥트만써도 데이터베이스연결가능 커넥트만부르면됨 > 메소드를 만드는 이유
	private void connect() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user14", "user14");
		}catch(Exception e) {
			System.err.println("연결실패");
			System.err.println(e.getMessage());
		}
	}
	
	//데이터베이스 연결 해제 하는 메소드
	private void close() {
		try {
			
		       pstmt.close();
		       con.close();
		}catch(Exception e) {
			System.err.println("연결 해제 실패");
			System.err.println(e.getMessage());
		}
	}
	
	// 여러개의 데이터를 가져오는 메소드
	// select는 where 절을 확인해서 매개변수를 생섯ㅇ
	// select*from TEAM
	public List<Map<String, Object>> allSoccerTeam() {
		//리턴할 데이터 생성<soccerteam
		//여러 개 일 떄는 생성자를 호출해서 인스턴스를 생성
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
	//데이터베이스 연결
	  connect();
	//sql 실행 객체 생성
	  try {
		pstmt = con.prepareStatement("select * from TEAM");
		//sql 실행
		ResultSet rs = pstmt.executeQuery();
		//데이터가 여러개 니까 while
		while(rs.next()) {
			//행단위 작업 수행
              //SoccerTeam imsi = new SoccerTeam();
            Map<String, Object> map = new HashMap<>();  
			//name 열의 값을 문자열로 읽어서 imsi에 저장
              //mybastis 나 Hivernate를 사용 할 떄 변수이름 필요없음
              //이작업은 나중에 할필요없음
             /* imsi.setNAME(rs.getString("NAME"));
              imsi.setWIN(rs.getInt("WIN"));
		      imsi.setLOSE(rs.getInt("LOSE"));
		      imsi.setDRAW(rs.getInt("DRAW"));
		      imsi.setSCORE(rs.getInt("SCORE"));
		      imsi.setRUNS(rs.getInt("RUNS"));
		*/
            map.put("이름", rs.getString("NAME"));
            map.put("WIN", rs.getString("WIN"));
            map.put("LOSE", rs.getString("LOSE"));
            map.put("DRAW", rs.getString("DRAW"));
            map.put("SCORE", rs.getString("SCORE"));
            map.put("RUNS", rs.getString("RUNS"));

            //list에 삽입
		      list.add(map);
		      
		      
		}
	  }catch(Exception e) {
		  System.err.println("Sql 실행 에러");
		  System.err.println(e.getMessage());
	  }
	
	  
	  
	  //데이터베이스 연결 해제
	  close();
	  
	  return list;
	
	
	}

	// NAME를 가지고 데이터를 찾아오는 메소드
	// NAME는 기본키
	// select * from TEAM where NAME = ?
	public SoccerTeam getSoccerTeam(String NAME) {
		SoccerTeam soccerteam = null;
		//데이터베이스 연결
		connect();
		//데이터베이스 작업
        try {
        	pstmt = con.prepareStatement("select *from TEAM " + "where NAME=?");
        	pstmt.setString(1, NAME);
        	//sql실행 
        	ResultSet rs = pstmt.executeQuery();
        	//데이터가 2개 이상 나올 수 없으므로 if로 처리
        	if(rs.next()) {
        		soccerteam= new SoccerTeam();
        		soccerteam.setNAME(rs.getString("NAME"));
        		soccerteam.setWIN(rs.getInt("WIN"));
        		soccerteam.setLOSE(rs.getInt("LOSE"));
        		soccerteam.setDRAW(rs.getInt("DRAW"));
        		soccerteam.setSCORE(rs.getInt("SCORE"));
        		soccerteam.setRUNS(rs.getInt("RUNS"));    	
        	}
        }catch(Exception e) {
        	System.err.println("상세보기에러");
        	System.err.println(e.getMessage());
        }
		
		//데이터베이스 연결 해제
		close();
		
		return soccerteam;
	}

	// 데이터를 삽입하는 메소드
	// 삽입이나 수정은 매개변수가 DTO 아니면 Map
	// -1이 리턴되면 실패 0이 리턴되면 조건에 맞는 데이터가 없음
	// 양수가 리턴되면 작업을 수행한 것임
	public int insertSoccerTeam(SoccerTeam soccerteam) {
		int result = -1;
            //데이터베이스 연결
	   connect();
		try {
			pstmt = con.prepareStatement("insert into TEAM(" + "NAME, WIN, LOSE, " + "DRAW, SCORE, RUNS) values(" + "?,?,?,?,?,?) "); 
			pstmt.setString(1, soccerteam.getNAME());		
	        pstmt.setInt(2, soccerteam.getWIN());	
	        pstmt.setInt(3, soccerteam.getLOSE());	
	        pstmt.setInt(4, soccerteam.getDRAW());	
	        pstmt.setInt(5, soccerteam.getSCORE());	
	        pstmt.setInt(6, soccerteam.getRUNS());
	        
	        //실행
	        result = pstmt.executeUpdate();
			
		
		
		}catch(Exception e) {
			System.out.println("삽입에러");
			System.out.println(e.getMessage());
		}
		
		
		close();
		return result;

	}

	// 데이터를 수정하는 메소드
	public int updateSoccerTeam(SoccerTeam soccerteam) {
		int result = -1;
       connect();
		try {
			pstmt = con.prepareStatement("update Team " + "set WIN = ?, LOSE = ? " + "where NAME = ?");
			pstmt.setInt(1, soccerteam.getWIN());
			pstmt.setInt(2, soccerteam.getLOSE());
			pstmt.setString(3, soccerteam.getNAME());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("데이터 수정 에러");
		    System.out.println(e.getMessage());
		}
       
       
       close();
       return result;

	}

	// 데이터를 삭제하는 메소드
	public int deleteSoccerTeam(String NAME) {
		int result = -1;
     connect();
     try {
    	 pstmt = con.prepareStatement("delete from TEAM "  + "where NAME = ?");
    	 pstmt.setString(1, NAME);
    	 result = pstmt.executeUpdate();
    			 
    	 
     }catch(Exception e) {
    	 System.out.println("삭제 에러");
    	System.out.println(e.getMessage());
     }
     
     
     
	close();	
     return result;
	}
   //매개변수가 name 이나 win에 포함된 데이터를 조회하는메소드
	//List, DTO 나 MAP, Scala(기본형, String, Date)
	public List<SoccerTeam> search(String word){
		List<SoccerTeam> list = new ArrayList<SoccerTeam>();
		connect();
	try {
		//대소문자 구분을 하지않고 싶으면 sql에서도 대문자나 소문자로 바꾸고 언어 안에서의 문자열도 대문자나 소문자로 변경
		pstmt = con.prepareStatement("select * from TEAM where " + "upper(NAME) like ? or " + "upper(WIN) like ? ");
		pstmt.setString(1, "%" + word.toUpperCase()  + "%");
		pstmt.setString(2,  "%" + word.toUpperCase() + "%");
		ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					SoccerTeam soccerteam = new SoccerTeam();
					
					soccerteam.setNAME(rs.getString("NAME"));
				list.add(soccerteam);
				}
	}catch(Exception e) {
		System.out.println("데이터검색 에러");
		System.out.println(e.getMessage());
	}
		
		
		
		close();
		return list;
	
	
	}


}

