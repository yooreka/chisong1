package datapossing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CSVRead {

	public static void main(String[] args) {
         try(CsvBeanReader reader = new CsvBeanReader(new BufferedReader(new InputStreamReader(new FileInputStream
    			 ("C:\\Users\\30414\\Documents\\2018년 관서별 청소년 5대범죄 현황.csv"))),CsvPreference.STANDARD_PREFERENCE)){
        	    //csv 파일 일기 객체 만들기
        //	System.out.println(reader);
        	 //첫번째 줄이 헤더인지 여부를 설정
        	 reader.getHeader(true);//그래야 첫번째 줄 안읽음
        	 //DTO클래스의 변수들을 순서대로 문자열 배열로 생성
        	 //이부분을 가지고 한줄의 데이터를 읽었을 때 변수에 대입
        	 String [ ] headers = {"classfication", "salin", "gangdo", "ganggan", "juldo", "pokhang"};
        	 //제약 조건 생성
        	 CellProcessor [ ] processors = new CellProcessor[] {
        			 new Optional(),
        			 new ParseInt(new Optional()),
        			 new ParseInt(new Optional()),
        			 new ParseInt(new Optional()),
        			 new ParseInt(new Optional()),
        			 new ParseInt(new Optional())
        	 };
        	 //읽은 데이터를 저장할 DTO의 LIst생성
        	 List<Crime> list = new ArrayList<Crime>();
        	 while(true) {
        		 Crime crime = reader.read(Crime.class, headers,processors);
        		 //더이상  읽지 못하면 종료
        		 if(crime == null) {
        			 break;
        		 }
        		 //읽는 경우에
        		 list.add(crime);
        	 }
        	 //데이터 사용
        	 for(Crime crime : list) {
        		 System.out.println(crime.getClassfication() + ":" + crime.getJuldo());
        	 }
         }catch(Exception e) {
        	 System.out.println(e.getMessage());
        	 e.printStackTrace();
         }
	}

}
