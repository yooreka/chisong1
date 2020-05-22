import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileInputStream;

public class CSVMain {

	public static void main(String[] args) {
		try(CsvBeanReader reader = new CsvBeanReader(new BufferedReader(new InputStreamReader(new FileInputStream
				("C:\\Users\\30414\\Documents\\soccer.csv"))),CsvPreference.STANDARD_PREFERENCE)){
			//헤더만들기
			//첫번째 행이 열제목이라고 설정하고 그내용을 headers에 저장
			String [ ]headers = reader.getHeader(true);
			//확인
			
		/*	 for(String title : headers) {
			 System.out.println(title);}
		*/
			CellProcessor [ ] processors = new CellProcessor[] {
					new NotNull(),
					new ParseDate("yyyy-MM-dd"),
					new NotNull(),
					new Optional(),
					new ParseInt(new NotNull())
			};
			List<Player> list = new ArrayList<Player>();
			//순회하면서 데이터를 읽어서 list에 추가
			while(true) {
				Player player = reader.read(Player.class, headers, processors);
			if(player == null) {
				break;
			}
			//읽은 데이터가 있으면 List에 저장
			list.add(player);
			
			}
			//list출력
			for(Player player : list) {
				System.out.println(player);
			}
		}catch(Exception e) {
			System.out.println("Csv 읽기 실패");
			System.out.println(e.getMessage());
            e.printStackTrace();		}

	}

}
