package intheritance5polymorphism;

public class Main {
//참조형 변수의 멤버 호출
	// 호출할 수 있는 것의 판든은 클래스를 가지고 판단
	// 오버라이딩 된 메소드는 생성자를 가지고 판단
	public static void main(String[] args) {
		Starcraft star = new Zerg();
		star.attack();

		Protoss p = new Protoss();
		star.attack();

		Terran t = new Terran();
		star.attack();

	}

}
