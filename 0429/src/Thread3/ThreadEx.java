package Thread3;

public class ThreadEx extends Thread {
        //스레드로 동작할 메소드
	@Override
	public void run() {
		//1초마다 저장 : 횟수 상관없이 수행
		try { 
			while(true) {
				Thread.sleep(1000);
				System.out.println("저장");
			}
			
		}catch(Exception e) {System.out.println
			("인터럽트발생");}
	}
	
	
	
}
