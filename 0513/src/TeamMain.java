import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class TeamMain {
	// satic 초기화
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 클래스 로드 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TeamDAO 인스턴스 생성
		TeamDAO tdao = TeamDAO.sharedInstance();

		mainloop: while (true) {
			System.out.println("팀 입력(1.전체 데이터로: 보기 2. 팀이름으로 데이터 조회하기" + "3.데이터삽입 4.데이터수정 5.데이터삭제 6.NAME이나WIN에 포함된 데이터 조회 7.종료):");
			String team = sc.nextLine();
			// switch 구문 내에서 사용할 변수는 밖에.
			List<SoccerTeam> list = null;
			SoccerTeam soccerteam = null;
			int result = -1;

			String NAME = null;
			switch (team) {
			case "1":
				// 전체 데이터 가져오는 메소드 호출
				//list = tdao.allSoccerTeam();
				List<Map<String, Object>> maplist = tdao.allSoccerTeam();
				// list 순회하면서 출력하기
				//for (SoccerTeam s : list) {
			//		System.out.println(s.getNAME() + ":" + s.getWIN() + "-" + s.getLOSE());
			for(Map g : maplist) {
				Set<String> keyset = g.keySet();
				for(String key : keyset) {
					System.out.print(g.get(key) + "\t");
				}
			System.out.println();
			
			}

				break;
			case "2":
				// 코드 1개 입력받기
				System.out.println("조회할 팀이름 입력");
				NAME = sc.nextLine();
				// dao 메소드 호출
				SoccerTeam sot = tdao.getSoccerTeam(NAME);
				if (NAME == null) {
					System.out.println("팀이름에 해당하는 데이터 없음");
				} else {
					System.out.println(sot);

				}
				break;
			case "3":
				// 삽입할 팀이름을 입력
				System.out.println("삽입할 팀이름 입력");
				NAME = sc.nextLine();
				// 팀이름에 해당하는 데이터를 가져오기
				soccerteam = tdao.getSoccerTeam(NAME);
				// 코드에 해당하는 데이터가 없으면
				if (soccerteam == null) {
					// 나머지 데이터 입력
					System.out.println("승리 입력");
					int WIN = sc.nextInt();
					System.out.println("패배 입력");
					int LOSE = sc.nextInt();
					System.out.println("무승부 입력");
					int DRAW = sc.nextInt();
					System.out.println("득점수 입력");
					int SCORE = sc.nextInt();
					System.out.println("실점수 입력");
					int RUNS = sc.nextInt();

					// 삽입할 데이터 생성
					soccerteam = new SoccerTeam();
					soccerteam.setNAME(NAME);
					soccerteam.setWIN(WIN);
					soccerteam.setLOSE(LOSE);
					soccerteam.setDRAW(DRAW);
					soccerteam.setSCORE(SCORE);
					soccerteam.setRUNS(RUNS);

					// Sql실행
					result = tdao.insertSoccerTeam(soccerteam);
					if (result > 0) {
						System.out.println("데이터 삽입 성공");
					} else {
						System.out.println("데이터 삽입 실패");
					}
				}
				// 코드에 해당하는 데이터가 있으면
				else {
					System.out.println("이미 존재하는 팀입니다.");

				}

				break;
			case "4":
				while (true) {
					System.out.println("수정할 팀이름을 입력");
					NAME = sc.nextLine();

					soccerteam = tdao.getSoccerTeam(NAME);
					// 데이터가 존재할 경우
					if (soccerteam != null) {
						System.out.println("수정할 승리 횟수");
						int WIN = sc.nextInt();
						soccerteam.setWIN(WIN);
						System.out.println("수정할 패배 횟수");
						int LOSE = sc.nextInt();
						soccerteam.setLOSE(LOSE);
							
						result = tdao.updateSoccerTeam(soccerteam);
						if(result > 0) {
							System.out.println("데이터 수정 성공");
						} else if(result == 0) {
							System.out.println("조건에 맞는 데잍 없음");
						}else {
							System.out.println("데이터 수정 실패");
						}
						break;
					} else {
						System.out.println("수정할 수 없는 팀입니다.");
					}

				}
				break;
			case "5":
				System.out.println("삭제할 팀이름 입력");
				NAME = sc.nextLine();
				soccerteam = tdao.getSoccerTeam(NAME);
				if(soccerteam == null) {
					System.out.println("없는코드입니다.");
				}else {
					//대화상자를 출력해서 묻기
					int r = JOptionPane.showConfirmDialog(null, "정말로 삭제", "삭제", JOptionPane.YES_NO_CANCEL_OPTION);
					 if(r == 0) {
						 //데이터 삭제
						 result = tdao.deleteSoccerTeam(NAME);
						 if(result > 0) {
							 JOptionPane.showMessageDialog(null, "삭제 성공");
						 }
					 }
				}
				
				
				break;
			case "6":
				System.out.println("이름이나 원산지를 입력:");
		        String word = sc.nextLine();
		        //데이터베이스 처리 메소드 호출
		        List<SoccerTeam> ar = tdao.search(word);
		        
		        for(SoccerTeam s : ar ) {
				System.out.println(s);
		        }	break;
		
			
			
			
			
			case "7":
				System.out.println("종료");
				// mainloop 라는 반복문을 종료
				break mainloop;
			default:
				System.out.println("잘못된 팀이름을 입력하셨습니다.");
				break;
			}
			// 실제로 만들때 내용을 먼저입력하지말고 먼저 테스트한후 내용을 입력.
			// 내용을 바로넣으면 무엇때문에 오류가 났는지 찾기 복잡

		}

		// 사용이 끝나면 키보드 연결 해제
		sc.close();
	}

}
