package datashare;

public class Main {

	public static void main(String[] args) {
	  sharedata obj1 = new sharedata();
	  sharedata obj2 = new sharedata();
	  
	  //noShare는 인스턴스 프로퍼티 이므로 변경해도 다른 인스턴스에는 아무런 영향이 없다
	  
	  obj1.noShare = "hello obj2";
	  
	  System.out.println(obj2.noShare);
		
	  sharedata obj3 = new sharedata();
	  sharedata obj4 = new sharedata();
	  
	  obj3.msg = "이번엔 공유 가능";
	  System.out.println(obj4.msg);
	  
	  obj3.globalchange();
	  System.out.println(gloverclass.yoo);

	  Singleton s1 = Singleton.sharedInstance();
	  Singleton s2 = Singleton.sharedInstance();
	//2개의 인스턴스가 동일한 지 확인은 해시코드를 이용
	  System.out.println(System.identityHashCode(s1));
	  System.out.println(System.identityHashCode(s2));
	
	Singleton.sharedInstance().anywhereshare = "Singleton";
	
	Parent p = new Parent();
	System.out.println(Thread.MAX_PRIORITY);
	
	int result = Math.max(20, 30);
	System.out.println(result);
	
	}
	
	

}
