import java.util.HashMap;

public class Morning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []song = {"보고싶다", "응급실", "처음처럼"};
      
		for(int i=0; i<song.length; i++) {
			
			System.out.printf(song[i] + "\t");}
		
	HashMap<String,Object> map1 = new HashMap<String,Object>();
	//가수이름과 노래제목을 하나로 묶어서 저장할 수 있는 클래스 또는 Map을 생성해서 데이터를 저장하고 
//이러한 데이터를 여러 개 만들어서 List 나 배열에 저장하고 출력 - 테이블 만들기
	map1.put("김범수", "보고싶다");
	map1.put("izi", "응급실");
	
	
	}

}
