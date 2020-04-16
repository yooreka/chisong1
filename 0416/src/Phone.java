
public class Phone {
//이름,전화번호,이메일
	//데이터를 저장할 변수는 인스턴스가 직접 접근할 수 없도록 private 로 생성
	
	private int num;
	private String name;
	private String phoneNumber;
	private String email;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//static 메소드 - 인스턴스 변수 사용 못함
	public static void staticMethod( ) {
		//지역변수를 생성해서 사용하는 것은 가능
		String msg = "Static Method";
		System.out.println(msg);
	}
	
}
