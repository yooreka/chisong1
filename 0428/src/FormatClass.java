import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatClass {

	public static void main(String[] args) {
		// 날짜 서식은 SimpleDateFormat
		//2020년 4월 28일 오후 5시 47분 형식으로 출력
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 mm"
				+ "월 dd일 EEE a hh시 mm분");
		String msg = sdf.format(date);
		System.out.println(msg);
		
		//숫자 서식 만들기
		DecimalFormat df = new DecimalFormat("\u00A4 #,###.00");
		msg = df.format(1250000);
		System.out.println(msg);
		
	}

}
