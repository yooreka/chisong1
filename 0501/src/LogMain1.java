import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class LogMain1 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader
				(new InputStreamReader(new FileInputStream("C:\\Users\\30414\\Desktop\\log.txt"))))
		{
			//IP를 중복없이 저장하기 위한 Set을 생성
			HashSet<String> set = new HashSet<>();
			 
			
			//파일의 전체 내용을 줄 단위로 읽기
			while(true) {
				//한 줄을 읽어서 line에 저장
				String line = br.readLine();
				//읽은 내용이 없으면 중단
				if(line == null) {
					break;
				}
				//읽은 데이터가 있으면 출력
				//System.out.println(line);
	             //공백을 기준으로 문자열 분할
				String [] data = line.split(" ");
				//분할된 데이터 중에서 첫번째 데이터만 출력
			//	System.out.println(data[0]);
			set.add(data[8]);
			}
			for(String ip : set) {
				
				System.out.println(ip);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
