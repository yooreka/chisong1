import java.io.IOException;

public class Systemmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//hello java를 10만 번 출력하는데 걸리는시간
		//hello java를 10만번 출력
		//시간을 측정 -테스트를 해주는 프로그램을 이용하기도함
	
		
		//현재 시간을 가져오는 메소드를 호출해서 결과를 저장
		long star = System.nanoTime();
		
		for(int i = 0; i <100000; i = i + 1) {
	  System.out.println("hello java");
	}
	//현재 시간을 가져오는 메소드를 호출
		long end = System.nanoTime();
	 System.out.println("걸린시간:" + (end-star));
	//프로세스 실행과 관련된 클래스의 인스턴스를 생성
	 Runtime r = Runtime.getRuntime();
	 try {
		r.exec("notepad.exe");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			 
	 
	}

}
