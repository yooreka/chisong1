
public class Member {
   //맨 처음 한 번만 수행
	static {
		System.out.println("처음 한 번만 수행");
	}
	//인스턴스가 만들어질 때 마다 수행
	{
		System.out.println("인스턴스가 만들어 질 때 마다 수행");
	}
	
	//프로퍼티는 값을 대입하지 않으면 숫자데이터는 0 boolean은 false 그리고 나머지는 null
	
	private String id;
     private String pw;
     private String name;
	//눈에 보이지는 않지만 자바가 생성해주는 생성자 매개변수는 없고 상위 클래스의 생성자를 호출하는 생성자
     //이렇게 매개변수가 없는 생성자를  //difault constructor라고 합니다
     //생성자는 리턴타입이 없고 이름은 클래스이름과 같아야함.
     public Member() {
    	 super();
    //프로퍼티에 기본값 설정
    	 id = "you7616";
    			 pw = "1234";
    			 name = "no exist";
     
     }
     //생성자 오버로딩
     //매개변수로 데이터를 대입받아서 프로퍼티에 대입하는 생성자
     public Member(String id, String pw, String name) {
    	 this.id = id;
    			 this.pw = pw;
    			 this.name = name;
     }
     
     
     public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
     
}
