
public class Phonemain {

	public static void main(String[] args) {
		//phone 클래스의 인스턴스 생성
		Phone obj1 = new Phone();
		//인스턴스를 이용해서 데이터 대입
		obj1.setEmail("yuchisong7@gmail.com");
		obj1.setName("유치송");
		obj1.setPhoneNumber("01022037616");
		obj1.setNum(1);
                //name을 가져와서 출력
		System.out.println("이름:" + obj1.getName());
	//변수에 직접 접근하는 것은 안됨
	//phone 클래스에 만든 static 메소드 호출
//static 매소드는 클래스 이름으로 호출
		Phone.staticMethod();

	}

}
