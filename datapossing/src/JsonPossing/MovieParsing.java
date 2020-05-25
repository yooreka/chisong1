package JsonPossing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieParsing {

	public static void main(String[] args) {
       //다운로드 받을 문자열을 저장할 변수
         String jsonString = null;
		//웹에서 다운로드 받기
		try {
    	    //다운로드 받을 주소 만들기
			String addr = "http://swiftapi.rubypaper.co.kr:2029/hoppin/movies?version=1&page=1&count=20&genreId=&order=releasedatease";
            //URL에 한글이 있으면 한글 부분은 utf - 8로 인코딩해야함
			//URLEncoder.encod("한글문자열", "utf-8")
			URL url = new URL(addr);
			
			//HttpURLConnection 생성
			//opnConnection은 URLConnection이라는 추상클래스 타입으로 리턴하므로 강제 형변환을 해서 인반 클래스 타입으로 변경
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(30000);//최대 연결 시간 설정
            con.setUseCaches(false);//이전에 받은 데이터 사용 여부
            
            //문자열을 읽은 스트림을 생성
            //읽은 내용이 깨질 때는 con.getInputStream 다음에, "인코딩 방식"을 추가
            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            //문자열을 읽기위한 임시변수를 생성
            StringBuilder sb = new StringBuilder();
            while(true) {
             //한줄 읽어오기
            	String line = bf.readLine();
            	//읽은데이터가없으면 종료
            	if(line == null) {
            		break;
            	}
           //읽은 데이터가 있으면 sb에추가
            	sb.append(line + "\n");
            }
    	  //연결종료
           bf.close();
           con.disconnect();
           //읽은 내용을 Stirng으로 변환
           jsonString = sb.toString();
       }catch(Exception e) {
    	   System.out.println("다운로드 실패 하였습니다.");
    	   System.out.println(e.getMessage());
    	   e.printStackTrace();
       }
        System.out.println(jsonString);
		//파싱 결과를 저장할 변수를 생성
        //title 과 ratingAverage를 저장
         //title 과 ratingAvergae를 Map에 저장
       List<Map<String, Object>> list = new ArrayList<>();
        //데이터파싱
       try {
    	   //텍스트가 존재하는 경우만 수행
    	   if(jsonString != null && jsonString.trim().length() > 0) {
    		   //첫번쨰는 JSON객체 
    		   JSONObject mainData = new JSONObject(jsonString);
    		   //System.out.println(mainData);
    		   //hoppin이라는 key의 값을 객체로 가져오기
    		   JSONObject hoppin = mainData.getJSONObject("hoppin");
    		  //System.out.println(hoppin);
    		   JSONObject movies = hoppin.getJSONObject("movies");
    		  // System.out.println(movies);
    		   JSONArray movie = movies.getJSONArray("movie");
    		   System.out.println(movie);
    		   for(int i=0; i<movie.length(); i++) {
    			   JSONObject imsi = movie.getJSONObject(i);
    			   System.out.println(imsi);
    			   String title = imsi.getString("title");
    			   String ratingAverage = imsi.getString("ratingAverage");
    			   //Map으로 생성
    			   Map<String, Object> map  = new HashMap<>();
    			   map.put("title", title);
    			   map.put("ratingAverage", Double.parseDouble(ratingAverage));
    			   //list에 추가
    			   list.add(map);
    					   }
    	   }else {
    		   System.out.println("다운로드 받은 문자열이 없음");
    		   //프로그램 조욜
    		   System.exit(0);
    	   }
       }catch(Exception e) {
    	   System.out.println("파싱실패");
    	   System.out.println(e.getMessage());
    	   e.printStackTrace();
       }
	
	System.out.println(list);
	
	//데이터베이스에 저장
	try {
		//드라이버 클래스 로드
	   Class.forName("com.mysql.jdbc.Driver");
	   //이 메시지가 출력안되면 mysql driver 프로젝트에 삽입하지 않았거나 드링버 클래스이름이 잘못됨
	//데이터베이스 연결 MySQL은 한글이 있는경우 연결 문자열에 유니코드 사용을 명시해야 합니다.
	  //?useUnicode=true&characterEncoding=utf8
	//MySQl과 java의 driver와 버전이 맞지 않아서 timezone에러가 발생하는 경우 추가
	   //&serverTimezone=UTC
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC","root","dbsguswjd132");
	   System.out.println("드라이버 클래스 로드");
	 // System.out.println(con);
	   for(Map<String, Object> map : list) {
		   PreparedStatement pstmt = con.prepareStatement("insert into movie(title, ratingaverage) "  + "values(?,?)");
	   pstmt.setString(1, (String)map.get("title"));
	   pstmt.setDouble(2, (Double)map.get("ratingAverage"));
	   
	   //SQL 실행
	   pstmt.executeUpdate();
	   pstmt.close();
	   
	   
	   }
	   
	   
	   con.close();
   	   }
	
	
	catch(Exception e) {
 	   System.out.println("데이터베이스 작업 실패");
 	   System.out.println(e.getMessage());
 	   e.printStackTrace();
	}
	}

}
