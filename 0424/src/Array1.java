
public class Array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] data = { "3000", "4000", "-", "4500" };
		// 위의 4개를 정수로 변환해서 합계를 구하기
		int sum = 0;
		for (String temp : data) {
		try {	// 문자열을 정수로 변환해서 sum에 더하기
			sum = sum + Integer.parseInt(temp);
		
		}catch(Exception e) { }
		}
		
		//출력할 메세지를 만들어서 출력
		String msg = String.format("합계:%d", sum);
		System.out.println(msg);

	}

}
