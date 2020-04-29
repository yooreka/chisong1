package thread2;

import java.util.Random;

public class RunableImpl implements Runnable {

	@Override
	public void run() {	
	try {
		//상하좌우를 번갈아가면서 3번씩 출력하기
		//0.2초마다 쉬면서 수행
		String [] action = {"상", "하", "좌", "우"};
		
		Random r = new Random();
		
		for(int i =0; i<12; i++) {
			Thread.sleep(200);
		 System.out.println(action[i%action.length]);
		
		}
		
	}catch(Exception e) {
		//자신만의 메세지를 출력하고 기록
		System.out.println("문제가발생");
		//예외 내용을 출력
		System.out.println(e.getMessage());
		//예외 발생지점 찾기
         e.printStackTrace();
	}

	}

}
