import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateMain {

	public static void main(String[] args) {
		//2018년 12월 18일을 Calendar 클래스의 인스턴스로 생성
		GregorianCalendar meetday = new GregorianCalendar (2017, 11, 18);
 
		//년도만 가졍괴
		System.out.println(meetday.get(Calendar.YEAR));
		//date로 변환
		//Calender가 날짜는 정확한데 데이터베이스와 연동은 Date로 해야함
		Date date = new Date(meetday.getTimeInMillis());
				System.out.println(date);
		//현재 날짜 및 시간 만들기
				GregorianCalendar today = new GregorianCalendar();
	//날짜 차이 계산
				long gap = today.getTimeInMillis() - meetday.getTimeInMillis();
	
	                  gap = gap /1000;
	                  gap = gap/86400;
	                  System.out.println("만나지" + gap + "일 째");
				
	}
	

}
