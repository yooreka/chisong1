
public class array {

	public static void main(String[] args) {
		// 3대운동의 종류
		// 배열의 데이터를 전부 출력 -리터럴이용
		// 데이터의 개수가 변경되면 코드를 변경
		// 변경하지 않으면 에러가 발생하거나 데이터를 전부 출력하지 못하게 됨
		String[] health = { "bench press", "deadlift", "squat", "babell row" };
		for (int i = 0; i < 3; i = i + 1) {
			System.out.println(health[i]);
		}
		System.out.println("--------------------");
		// 배열의 속성을 이용해서 전부 출력
		// 데이터를 출력할 때 데이터의 속성을 이용하면 데이터가 변경되었을 때 자동으로 적용됩니다.
		// 데이터가 변경되더라도 출력하는 코드를 수정할 필요가 없어집니다 이러한 방식을 mvc pattern이라고 합니다
		// mode1 - 데이터를 만드는 부분 (back end, business logic) , view - 데이터를 출력하는 부분(front
		// end, presentation logic)
		// controller - model 과 view를 연결하는 부분
		for (int i = 0; i < health.length; i = i + 1) {
			System.out.println(health[i]);
		}
		System.out.println("-----------");
		// 여러개의 데이터 안에 포함된 length를 1개의 데이터인 len에 복사합니다
		// 다음부터 len을 이용하게 되면 .length보다 메모리 접근 횧수가 줄어들어서 더 효율적인 반복문이됨
		int len = health.length;
		for (int i = 0; i < len; i = i + 1) {
			System.out.println(health[i]);
		}

	}

}