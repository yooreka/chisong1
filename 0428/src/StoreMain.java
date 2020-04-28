import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class StoreMain {

	public static void main(String[] args) {
		// 테이블 형태의데이터생성
		ArrayList<Store> list = new ArrayList<>();
		
		list.add(new Store("1", "화선", 4.4, 10000, "짬뽕"));
		list.add(new Store("2", "수선", 3.4, 11000, "짜장"));
		list.add(new Store("3", "목선", 2.4, 12000, "탕수육"));
		
	    //데이터출력
		System.out.println("코드\t이름\t평점\t최소주문금액\t메뉴");
	  for(Store store : list) {
		  System.out.println(store.getCode()+"\t"
				  + store.getName()+"\t"
				  + store.getAverage()+"\t"
				  + store.getMinOrderMoney()+"\t"
				  + store.getMenu()+"\t"
				  );
	  }
	ArrayList<LinkedHashMap<String,Object>>
	stores = new ArrayList<>();
	
	LinkedHashMap<String, Object> store1 = new LinkedHashMap<>();
	store1.put("code", "1");
	store1.put("name","화선");
	store1.put("grade", 4.4);
	store1.put("minordermoney", 10000);
	store1.put("menu", "짬뽕");
	stores.add(store1);
	for(LinkedHashMap<String,Object> map : stores) {
		Set<String>keys = map.keySet();
		for(String key:keys) {
			System.out.printf(map.get(key) + "\t");
			
		}
	}
	// 수정하기엔 밑에방법이 더 편함
	//mvc패턴이나 framework 은 Map쓰는게 좋음
	
	
	
	}

}
