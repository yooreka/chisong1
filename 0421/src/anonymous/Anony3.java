package anonymous;

public class Anony3 {

	public static void main(String[] args) {
		Anony2 obj = new Anony2();
		obj.method();

		// Anony1 클래스를 상속받는 Anonymous class
		Anony1 obj1 = new Anony1() {

			@Override
			public void method() {
				System.out.println("anonymous를 이용한 상속 구현");

			}

		};
obj1.method();
	}

}
