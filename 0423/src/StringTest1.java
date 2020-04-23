
public class StringTest1 {

	public static void main(String[] args) {
      //문자열 인스턴스를 생성 - 리터럴을 이용해서 생성
		String str = "Tottenham";
        //문자열의 길이(lengh)를 출력
	int len = str.length();
	System.out.println(len);
	//문자열 안에서 특정한 위치의 문자를 출력
	//char charAt(int idx)
	char where = str.charAt(0);
	System.out.println(where);
	
	//str에 있는 모든 문자를 순서대로 출력
	int big = 0;
	int small = 0;
	int num = 0;
	int etc = 0;
	//소문자, 숫자, 기타문자의 개수 구하기
	for(int i = 0; i<str.length(); i++) {
		char ch = str.charAt(i);
		if(ch >= 'A' && ch <= 'Z') {
			big = big + 1;
		}
		else if(ch >= '0' && ch <= '9' )	{
			num = num + 1;
		}
		else if(ch >='a' && ch<='z') {
			small = small + 1;
		}
		else {
			etc = etc + 1;
		}
	}
	
	System.out.println("대문자 개수:" + big);
	System.out.println("숫자 개수:" + num);
	System.out.println("소문자 개수:" + small);
	
	
	System.out.println("특수문자 개수:" + etc);
	
	if(big>0 && small>0 && num>0 && etc>0) {
		System.out.println("사용가능비번");
	}
	else {
		System.out.println("사용불가비번");
	}
	String obj1 = "ios";
			String obj2 = "IOS";
			String ojb3 = "windows";
	System.out.println(obj1.toUpperCase().equals("IOS"));
	System.out.println(obj2.toUpperCase().equals("IOS"));
	System.out.println(ojb3.toUpperCase().equals("IOS"));
	}
	
	

}
