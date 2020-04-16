
public class students {
//회원정보 
	// public이 붙으면 클래스 안에서 사용할 수 있고 인스턴스를 만들어서 인스턴스를 이용해서 사용가능
	public String name;
	public int age;
	public int tall;
	public int weight;
	public int tell;
//주소를 저장하기 위한 변수
	static public String adress;

	// 데이터를 출력하는 메소드
	 public void disp() {
	 System.out.println("이름:" + name);
	 System.out.println("나이:" + age);
	 System.out.println("키:" + tall);
	System.out.println("몸무게:" + weight);
	 System.out.println("전화번호:" + tell);
	 }
	public int sum() {
		int tot = age + tall;
		return tot;

	}

}
