import java.io.UnsupportedEncodingException;

public class StringFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer x = 100;
		Integer y = 300;

		// 인스턴스를 문자열로 변환 - toString 호출
		// 프로그래밍언어마다 이러한 메소드가 존재

		String str = x.toString();

		// 문자열 과 문자열결합
		str = x.toString() + y.toString();
		System.out.println(str);

		// x : 100 y: 200
		// 숫자는 5자리로 표현
		// 되도록이면 변수에 저장하고 출력 > 지금은 콘솔에 출력하기 때문에 printf를 이용하지만
		// GUI 프로그램에서는 뷰에 텍스트를 설정하기 때문에 문자열 데이터를 대입하는 구조로 출력함
		str = String.format("x:%5d y:%5d", x, y);
		System.out.println(str);
		System.out.printf("x:%5d y:%5d", x, y);

		// 한글을 저장한 문자열 인스턴스
		String hangul = "한글 문자열";
		try {
			byte[] bytes = hangul.getBytes("UTF - 8");
			//바이트 배열을 문자열로 변환
			String st = new String(bytes, "UTF-8");
			System.out.println(st);
			

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 위의
	}

}
