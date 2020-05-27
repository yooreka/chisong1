import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HaniMain {

	public static void main(String[] args) {
		String html = null;
		try {
			// URL 만들기 - 파라미터에 한글이 있으면 파라미터를 인코딩
			// 파라미터는 ? 다음에 나오는 문자열
			String addr = "http://www.hani.co.kr/";
			URL url = new URL(addr);
			// 연결 객체 만들기
			// header에 추가하는 옵션이 있는지 확인
			// header가 있는 경우는 api key 나 id 나 비밀번호를
			// 설정해야하는 경우
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(30000);
			con.setUseCaches(true);
			// 스트림을 사용해서 문자열을 읽어오는 부분
			// 읽었는데 한글이 깨지면 InputStreamReader
			// 생성자에 euc-kr 추가
			BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));

			// 문자열을 읽기위한 임시변수를 생성
			StringBuilder sb = new StringBuilder();
			while (true) {
				// 한줄 읽어오기
				String line = bf.readLine();
				// 읽은데이터가없으면 종료
				if (line == null) {
					break;
				}
				// 읽은 데이터가 있으면 sb에추가
				sb.append(line + "\n");
			}
			// 연결종료
			bf.close();
			con.disconnect();
			// 읽은 내용을 Stirng으로 변환
			html = sb.toString();

		} catch (Exception e) {
			System.out.println("다운로드실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// System.out.println(html);
		if (html != null && html.trim().length() > 0) {
			// 문서 구조 가져오기
			Document document = Jsoup.parse(html);

			// 선택자 이용해서 가져오기
			Elements elements = document.select("#main-top01-scroll-in > div.article01.first > div > h4 > a");
	        //선택자를 이용한 것은 반목문을 수행 
			for(int i =0; i<elements.size(); i++) {
	        	//DOM 1개 가져오기
				Element element = elements.get(i);
	        	//태그안의 내용가져오기 
				//System.out.println(element.text());
			   //시작태그안의 href링크가져오기
				System.out.println(element.attr("href"));
		          
			}
		   
		
		} else {
			System.out.println("읽어온 데이터가 없음");
		}

	}
}