
public class Stringtest2 {

	public static void main(String[] args) {
		// 문자열분할
		// substring은 위치를 가지고 분할
		String msg = "HelloWolrd";
		// 4번째 부터 끝까지 문자열을 분할
		System.out.println(msg.substring(4));
		// 4번째부터 6번째까지 문자열을 분할
		System.out.println(msg.substring(4, 7));

		String contextPath = "http://localhost:9000";
		String uriString = "http://localhost:9000/index.jsp";
		// uriString 에서 contextPath를 제외한 부분을 출력
		// 잘라낼 글자수 만들기
		int len = contextPath.length();
		// 잘라내기
		String result = uriString.substring(len);
		System.out.println();
		// split은 패턴을 가지고 분할

		String data = "10000,-,4300,3700";
		// 위의 문자열을, 로 분할해서 출력하기
		String[] ar = data.split(",");
		// 배열의 데이터 출력
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		// 배열의 데이터 출력
		// 빠른 열거를 이용한 접근
		// ar의 데이터를 순서대로 temp에 하나씩 대입

		// ar에 있는 데이터는 숫자로 된 문자열 숫자를 정수로 변환해서 합계 구하기
		int sum = 0;
		for (String temp : ar) {
			sum = sum + Integer.parseInt(temp);
			System.out.println(sum);
		}
     String coupang = "0420,10000,0421,20000,0422,-,0423,14000";
     //위에 데이터는 날짜와 매출을 연속적으로 기록한것임 위의 데이터를 가지고 매출의 평균을 구하시오
     //-는 매출이 없는 것이아니라 영업을 하지 않은 경우 이므로 제외하고 매출의 평균을 구하세요
     //1. ,단위로 분할해서출력
     //2.짝수번째 데이터만 출력
     //3.짝수번쨰 데이터의 평균 구하기
		
	}

}
