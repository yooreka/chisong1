package intheritance4;

public class Main {

	public static void main(String[] args) {
	//상위 클래스 타입으로 만들어진 변수에 하위 클래스 타입의 인스턴스를 형 변환없이 대입 가능
		//Manager 클래스가 emplpyee 클래스의 하위 클래스 라서 가능
		emplpyee em1 = new Manager();
	//하위클래스 타입의 변수에는 상위 클래스 타입의 인스턴스를 바로대입할수 없고 강제 형 변환을 해서 대입해야 합니다
		//원래 자료형이 하위 클래스 타입이 아니면 예외 발생

		//Manager mgr2 = new emplpyee;
		//em2는 Manager()를 호출해서 만들었는데 emlplyee 변수에 저장한 것이라서 형변환해서 대입하면 문제 없음
		Manager mgr3 = (Manager)em1;
		
	//에러는 아니지만 실행 시 예외가 발생
		//ClassCastException 생성할 때 Employee로 생성해서 Manager로 변경 불가
	}

}
