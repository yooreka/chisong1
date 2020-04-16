
public class instancevariable {

	public static void main(String[] args) {
		//students 클래스의 인스턴스를 생성
		students a = new students();
		//인스턴스를 이용해서 프로퍼티 접근
		a.name  = "유치송";
		a.age = 27;
		//다른인스턴스 생성
		students b = new students();
		b.name = "아케미";
		b.age = 26;
//클래스 안에 static 없이 만들어진 변수는 프로퍼티라고 합니다.(인스턴스마다 별도로 생성)
		System.out.println(a.name);
	    System.out.println(b.name);
	
	 ///되도록이면 클래스이름으로 접근   
	 //a.adress = "japan";
	//b.adress = "korea";
	students.adress = "america";
	System.out.println(a.adress + b.adress);
	a.disp();
	int tot = a.sum();
	double avg = tot / 2.0;
	System.out.println("나이 + 키 = " + tot);
	}

}
