import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Morning {
//파일을읽어와서
	public static void main(String[] args) {
	    try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./log.txt")))){
	          //파일에저장
	    	Map<String, Object>map = new HashMap<>();
	 while(true) {
		 //한줄가져오기
		 String line = br.readLine();
	    //가져올데이터가 없으면 끝
		 if(line == null) {
			 break;
		 }
	     //데이터 출력
		// System.out.println(line);
	  //분할해서출력하기
		 String [] ar = line.split(" ");
	 //ip와 traffic 출력
		 System.out.println(ar[0] + ":" + ar[9]);
	 
	 }
	    }catch(Exception e) {}
	 
	}

}
