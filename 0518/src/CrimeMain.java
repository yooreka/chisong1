import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CrimeMain {

	public static void main(String[] args) {
		// 데이터베이스 사용 객체를 생성
		CrimeDAO dao = CrimeDAO.sharedInstance();
		Scanner sc = new Scanner(System.in);
		// 이름을 붙인 이유는 내부에서 switch 를 사용할 것이고 7번을 누를 대 반복문을 한번에 빠져나오기 위해.
		mainloop: while (true) {
			System.out.println("1.전체보기 2.2개씩 보기 3.상세보기" + "4.데이터삽입 5.데이터수정 6.데이터삭제" + "7.프로그램종료");
			System.out.println("메뉴입력");
			String menu = sc.nextLine();
			// 여러개의 데이터를 저장하기 위한 변수
			List<Crime> list = null;
			// 하나의 데이터를 저장하기 위한 변수
			Crime crime = null;
			// 삽입, 삭제, 갱신의 결과를 저장하기 위한 변수
			int result = -1;

			// Crime 각가을 위한 변수
			String categorize = null;
			int allcrime = -1;
			int mentalcrime = -1;
			double persent = -1;
			// 입력을 받기 위한 임시변수
			String temp = null;
			switch (menu) {
			case "1":
				// 전체 가져오기 호출
				list = dao.allcrime();
				// 데이터 출력
				System.out.printf("%10s%10s%10s\n", "구분", "범죄자수", "정신이상자비율");
				for (Crime imsi : list) {
					System.out.printf("%10s%15d%10.7f\n", imsi.getCategorize(), imsi.getAllcrime(), imsi.getPersent());
				}
				break;
			case "2":
				// 전체 데이터 개수 가져오기
				int cnt = dao.getCount();
				// System.out.println("데이터개수:" + cnt);
				// 페이지 수 만들기 - 페이지당 데이터 개수는 2
				int pagesu = (int) ((double) cnt / 2 + (double) (2 - 1) / 2);
				// System.out.println("페이지개수:" + pagesu);
				list = dao.pageCrime(1, 2);
				for (Crime imsi : list) {
					System.out.println(imsi);
				}
				int pageno = 1;
				while (true) {
					/*
					 * //조회할 페이지 번호 입력받기 System.out.println("페이지 번호(1-" + pagesu + ") 종료는 0:"); temp
					 * = sc.nextLine(); try { int pageno = Integer.parseInt(temp); //데이터의 값을 확인해서
					 * 작업을 수행 : 유효성 검사 if(pageno == 0) { break; }else if(pageno >= 1 && pageno <=
					 * pagesu) { list = dao.pageCrime(pageno, 2); for(Crime imsi : list) {
					 * System.out.println(imsi); } }else { System.out.println("잘못된 페이지 번호"); }
					 * }catch(Exception e) { System.out.println(e.getMessage());
					 * e.printStackTrace(); }
					 * 
					 */
					// 아무키나 누르고 enter치면 종료
					// 그냥 엔터 치면 다음페이지 데이터도 가져와서 출력하기
					System.out.println("아무키타 누르면 종료");
					System.out.print("enter만 누르면 다음페이지 가져오기");
					temp = sc.nextLine();
					if (temp.trim().length() == 0) {
						pageno = pageno + 1;
						if (pageno > pagesu) {
							System.out.println("더이상 가져올 데이터 없음");
						} else {
							// pageno에 해당하는 데이터 가져오기
							List<Crime> currenData = dao.pageCrime(pageno, 2);
							// 위의 데이터를 list에 추가
							list.addAll(currenData);
							// 출력
							for (Crime imsi : list) {
								System.out.println(imsi);
							}
						}
					} else {
						break;
					}
				}

				break;
			case "3":
				System.out.print("조회할범죄:");
				temp = sc.nextLine();
				try {
					crime = dao.getCrime(temp);
					if (crime == null) {
						System.out.println("해당하는 범죄의 데이터가 없습니다");
					} else {
						System.out.println(crime);
					}
				} catch (Exception e) {
					System.out.println("다시입력하세요");
					break;
				}
				break;
			case "4":
				// categorize를 입력
				temp = sc.nextLine();
				try {
					crime = dao.getCrime(temp);
					//
					if (crime == null) {
						// 구분 입력 받기
						System.out.println("구분 :");
						categorize = sc.nextLine();
						// 모든범죄,정신범죄, 퍼센트 입력받기
						System.out.println("모든범죄자수 :");
						temp = sc.nextLine();
						allcrime = Integer.parseInt(temp);

						System.out.println("정신범죄자수 :");
						temp = sc.nextLine();
						mentalcrime = Integer.parseInt(temp);

						System.out.println("비율 :");
						temp = sc.nextLine();
						persent = Double.parseDouble(temp);
						// 데이터 베이스 메소드로 넘겨주기위해 입력받은 데이터를 1개로만들기
						crime = new Crime();
						crime.setAllcrime(allcrime);
						crime.setCategorize(categorize);
						crime.setMentalcrime(mentalcrime);
						crime.setPersent(persent);

						// 데이터베이스 메소드 호출
						result = dao.insertCrime(crime);
						// 결과사용
						if (result > 0) {
							System.out.println("데이터 삽입 성공");
						} else {
							System.out.println("데이터 삽입 실패 ");
						}
					} // categorize가 존재하는 경우
					else {
						System.out.println("이미 존재하는 데이터입니다.");
					}
				} catch (Exception e) {
					System.out.println("다시입력하세요");
				}

				break;
			case "5":
				System.out.println("수정할 범죄");
				categorize = sc.nextLine();
				// 데이터 존재여부확인
				crime = dao.getCrime(categorize);
				if (crime == null) {
					System.out.println("수정할 수 없는 데이터입니다.");
				} else {
					System.out.println("수정하지 않으려면 Enter");
					System.out.println("모든범죄자수(이전-" + crime.getAllcrime() + "):");
					temp = sc.nextLine();
					// 숫자가 10이상이면 이전 값 갖기
					if (temp.trim().length() == 0) {
						allcrime = crime.getAllcrime();
					} else {
						allcrime = Integer.parseInt(temp);
					}

					System.out.println("수정하지 않으려면 Enter");
					System.out.println("정신범죄자수 입력(이전-" + crime.getMentalcrime() + "):");
					temp = sc.nextLine();
					// 숫자가 10이상이면 이전 값 갖기
					if (temp.trim().length() == 0) {
						mentalcrime = crime.getMentalcrime();
					} else {
						mentalcrime = Integer.parseInt(temp);
					}
					System.out.println("수정하지 않으려면 Enter");
					System.out.println("비율 입력(이전-" + crime.getPersent() + "):");
					temp = sc.nextLine();
					// 숫자가 10이상이면 이전 값 갖기
					if (temp.trim().length() == 0) {
						persent = crime.getPersent();
					} else {
						persent = Double.parseDouble(temp);
					}

					// 입력받은데이터 하나로 만들기
					crime.setAllcrime(allcrime);
					crime.setMentalcrime(mentalcrime);
					crime.setPersent(persent);

					result = dao.updateCrime(crime);

					if (result > 0) {
						System.out.println("수정 성공");
					} else {
						System.out.println("수정 실패");
					}

				}
				break;
			case "6":
				System.out.println("삭제할 범죄:");
				temp = sc.nextLine();
				// 데이터의 존재 여부를 확인
				crime = dao.getCrime(temp);
				if (crime == null) {
					System.out.println("삭제할 수 없는 데이터입니다.");
				} else {
					// 정말로 삭제할 것인지 확인
					System.out.println("정말로 삭제(Y):");
					temp = sc.nextLine();
					// 영문을 입력받아서 비교
					if (temp.trim().toUpperCase().equals("Y")) {
						// 삭제
						result = dao.deleteCrime(crime.getCategorize());
						// 삭제 결과 사용
						if (result > 0) {
							System.out.println("삭제성공");

						} else {
							System.out.println("삭제실패");
						}
					}
				}
				break;
			case "7":
				System.out.println("프로그램종료");
				break mainloop;
			default:
				System.out.println("잘못된 메뉴 선택!");
				break;

			}

		}

		sc.close();
	}

//1.전체보기를 위한 메소드
	// 조회는 몇 열의 데이터를 몇 행으로 조회하는지 : 리턴타임
	// where 절이 있는지 확인 : 파라미터
	// select * from Crime
	public List<Crime> allcrime() {

		List<Crime> list = new ArrayList<Crime>();
		// 데이터 베이스 연결

		// 데이터가 없을 때는 List의 size가 0
		return list;

	}

}
