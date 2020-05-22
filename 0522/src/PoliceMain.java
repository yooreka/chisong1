import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileInputStream;

public class PoliceMain {

	public static void main(String[] args) {
		try(CsvBeanReader reader = new CsvBeanReader(new BufferedReader(new InputStreamReader(new FileInputStream
				("C:\\Users\\30414\\Documents\\경찰청_음주운전적발기록_20200518.csv"))),CsvPreference.STANDARD_PREFERENCE)){
			//헤더만들기
			//첫번째 행이 열제목이라고 설정하고 그내용을 headers에 저장
			String [ ]headers = reader.getHeader(true);
			//확인
			
			 for(String title : headers) {
			 System.out.println(title);}
		
			
			
		}catch(Exception e) {
			System.out.println("Csv 읽기 실패");
			System.out.println(e.getMessage());
            e.printStackTrace();		}

	}

}
