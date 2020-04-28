import java.util.HashMap;
import java.util.Map;

public class MapMain2 {

	public static void main(String[] args) {
		// 2차원배열 - 배열의 배열 프로야구 선수들의 팀별 선수 명단을 데이터로 작성

		String[] huston = { "벌렌더", "로사리오" };
		String[] toronto = { "류현진", "블게주" };
		String[] la = { "커쇼", "마에다" };
		String[] boston = { "다나카", "프라이스" };

		// 이차원배열생성
		// 배열에는 비교가 가능한 데이터만 저장하기 때문에 데이터이외의 정보를 저장하지 못해서 이차원 배열을 이용하는 배열의 특성을 출력불가
		String[][] players = { huston, toronto, la, boston };
		for (int i = 0; i < players.length; i++) {
			// 팀이름출력
			if (i == 0) {
				System.out.printf("%5s", "huston:");
			} else if (i == 1) {
				System.out.printf("%5s", "toronto:");

			} else if (i == 2) {
				System.out.printf("%5s", "la:");

			} // 각 팀의 선수명단
			String[] temp = players[i];
			for (String imsi : temp) {
				System.out.printf("%7s", imsi);
			}

			System.out.printf("\n");

			// 배열을 하나로 묶어 줄 대는 Map을 만들어서 배열의 특징과 데이터를 저장하고 Map의 배열을 만들어주는게 좋음
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			map1.put("team", "huston");
			map1.put("player", huston);

			HashMap<String, Object> map2 = new HashMap<String, Object>();
			map2.put("team", "toronto");
			map2.put("player", toronto);

			HashMap<String, Object> map3 = new HashMap<String, Object>();
			map3.put("team", "la");
			map3.put("player", la);

			HashMap[] mlb = { map1, map2, map3 };
			for (HashMap map : mlb) {
				System.out.printf("%5s", map.get("team"));
				// 출력이외의 작업을 할 때는 원래 자료형으로 형 변환해서 사용
				String[] player = (String[]) map.get("player");
				for (String p : player) {
					System.out.printf("%7s", p);
				}
			}
			System.out.printf("\n");

		}

	}

}
