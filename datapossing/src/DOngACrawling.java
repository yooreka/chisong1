import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DOngACrawling {

	public static void main(String[] args) {
	
			String html = null;
			try {
				// URL 만들기 - 파라미터에 한글이 있으면 파라미터를 인코딩
				// 파라미터는 ? 다음에 나오는 문자열
              String query = "유치송";
              query = URLEncoder.encode(query, "utf-8");
				String addr = "https://www.donga.com/news/search?p=1&query="
						+ query
						+ "&check_news=1&more=1&sorting=1"
						+ "&search_date=1&v1=&v2=&range=1";
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
     //System.out.println(html);
		//데이터 건수를 저장할 변수
			int cnt = -1;
			try {
				
				//텍스트를 메모리 펼치기
				Document document = Jsoup.parse(html);
				Elements elements = document.select("#content > div.searchContWrap > div.searchCont > h2 > span:nth-child(1)");
				for(int i=0; i<elements.size(); i=i+1) {
					Element element = elements.get(i);
					String content = element.text();
			//	System.out.println(content);
				///공백을 기준으로 분할 >건수만 찾아오기위해
					String [ ] ar = content.split(" ");
					cnt = Integer.parseInt(ar[1]);
					//System.out.println(cnt);//
				}
				
			}catch(Exception e) {
				System.out.println("다운실패");
				System.out.println(e.getMessage());
				e.printStackTrace();
				
	}
			int perPageCnt= 15;
	        //페이지 개수 계산
			//전체데이터 개수를 페이지당 데이터 개수로 나누고 나머지가 있으면 페이지 개수를1개추가
			int pageCnt = cnt / perPageCnt;
			if(cnt % perPageCnt !=0) {
				pageCnt = pageCnt + 1;
			}
			//System.out.println(pageCnt);
			
			//기사의 링크를 저장할 변수
			List<String>list  = new ArrayList<>();
			try {
				for(int i=0; i<pageCnt; i=i+1) {
					try {
						String query = "유치송";
			              query = URLEncoder.encode(query, "utf-8");
							String addr = "https://www.donga.com/news/search?p="
									+ ((i*perPageCnt) + 1)
									+ "&query="  + query
									+ "&check_news=1&more=1&sorting=1"
									+ "&search_date=1&v1=&v2=&range=1";
							URL url = new URL(addr);
						
							HttpURLConnection con = (HttpURLConnection) url.openConnection();
							con.setConnectTimeout(10000);
							con.setUseCaches(false);
							
							BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
							
							StringBuilder sb = new StringBuilder();
							while(true) {
								String line = bf.readLine();
										if(line == null) {
											break;
										}
								sb.append(line + "\n");
							}
							bf.close();
							con.disconnect();
							html = sb.toString();
							//System.out.println(html);
							
							//링크 수집을 위해서 html파싱
							Document doc = Jsoup.parse(html);
							//선택자가 너무 길 때는 앞쪽은 생략해도 됩니다.
							Elements elements = doc.select("div:nth-child(2) > div > p.tit > a:nth-child(1)");
							System.out.println(elements);
							
							for(int j=0; j<elements.size(); j=j+1) {
								Element element = elements.get(j);
								//a 태그의href 속성을 list에 저장
								list.add(element.attr("href"));
								System.out.println(list);
							}
				}catch(Exception e) {
					System.out.println("현재 페이지 읽어오기 실패");
					System.out.println(e.getMessage());
					e.printStackTrace();
					}
			}
			}catch(Exception e) {
				System.out.println("기사 링크 저장 실패");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			//현재 디렉토리에 유치송.txt 파일에 기사내용 저장 
			//try()안에 만든 객체는 close를 호출할 필요없음
			try(PrintWriter pw = new PrintWriter("./유치송.txt")){
				for(String link : list) {
					 try {
							URL url = new URL(link);
							HttpURLConnection con = (HttpURLConnection)url.openConnection();
							con.setConnectTimeout(10000);
							con.setUseCaches(false);
							
							BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
							
							StringBuilder sb = new StringBuilder();
							while(true) {
								String line = bf.readLine();
										if(line == null) {
											break ;
										}
								sb.append(line + "\n");
							}
							bf.close();
							con.disconnect();
							html = sb.toString();
							//System.out.println(html);
							//pw.println(html);
				             
							//기사 내용만 골라서 파일에 저장
							Document document = Jsoup.parse(html);
							Elements elements = document.select("#content > div > div.article_txt > strong");
							for(int k=0; k<elements.size(); k++) {
								Element element = elements.get(k);
								pw.println(elements.text());
								pw.flush();}
					 }catch(Exception e) {
							System.out.println("기사 가져오기 실패");
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
				}
				
			}catch(Exception e) {
				System.out.println("기사 링크 저장 실패");
				System.out.println(e.getMessage());
				e.printStackTrace();
	}
	}
}
