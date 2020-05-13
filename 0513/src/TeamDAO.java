import java.util.ArrayList;
import java.util.List;

//데이터베이스 연동 메소드를 소유한 클래스
public class TeamDAO {
	// 싱글톤 패턴 디자인 = 객체를 1개만 생성할 수 있도록 만든 패턴
	// 외부에서 생성할 수 없도록 생성자를 private로
	private TeamDAO() {
	}

	// 만들어진 객체의 참조를 저장하기 위한 변수
	private static TeamDAO teamDAO = null;

	// 객체가 없으면 만들어서 리턴하고
	// 있으면 있는 것을 리턴하도록 하는 객체 사용을 위한 메소
	public static TeamDAO sharedInstance() {
		if (teamDAO == null) {
			teamDAO = new TeamDAO();
		}
		return teamDAO;
	}

	// 여러개의 데이터를 가져오는 메소드
	// select는 where 절을 확인해서 매개변수를 생섯ㅇ
	// select*from TEAM
	public List<SoccerTeam> allSoccerTeam() {
		List<SoccerTeam> list = new ArrayList<SoccerTeam>();
		return list;
	}

	// code를 가지고 데이터를 찾아오는 메소드
	// code는 기본키
	// select * from TEAM where code = ?
	public SoccerTeam getSoccerTeam(String code) {
		SoccerTeam soccerteam = null;

		return soccerteam;
	}

	// 데이터를 삽입하는 메소드
	// 삽입이나 수정은 매개변수가 DTO 아니면 Map
	// -1이 리턴되면 실패 0이 리턴되면 조건에 맞는 데이터가 없음
	// 양수가 리턴되면 작업을 수행한 것임
	public int insertSoccerTeam(SoccerTeam soccerteam) {
		int result = -1;

		return result;

	}

	// 데이터를 수정하는 메소드
	public int updateSoccerTeam(SoccerTeam soccerteam) {
		int result = -1;

		return result;

	}

	// 데이터를 삭제하는 메소드
	public int deleteSoccerTeam(String code) {
		int result = -1;

		return result;
	}
}