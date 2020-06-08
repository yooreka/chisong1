import java.util.HashMap;
import java.util.Set;

public class MapMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    HashMap<String, Object> map =
	    		new HashMap<>();
	   //데이터 저장
	    map.put("title", "iphones");
	    map.put("style", "black");
	    map.put("color", "pink");
	    //데이터 꺼내오기 - 없는 key를 사용하면 null
	    System.out.println(map.get("title"));
	    System.out.println(map.get("money")); 
	   //데이터 수정
	    map.put("title", "note");
	    System.out.println(map.get("title"));
	    System.out.println(map.values());
	   //데이터삭제
	    map.remove("title");
	    System.out.println(map);
	    //Map의 전체 데이터 순회
	    Set <String> keys = map.keySet();
	    for(String key : keys) {
	    	System.out.println(key + ":" + map.get(key));
	    }
	    } 

}
