package thread2;

public class ThreadEx extends Thread {
//스레드로 동작할 메소드
	@Override //안해도 되는데 //상위클래스에 없는 메소드에 붙이면 에러

  public void run () {
		try {
			//0.5초마다 문자열을 10번출려
			for(int i=0; i<9; i++) {
				Thread.sleep(500);
				System.out.println("라투");
			}
			System.out.println("라투사망");
		}catch(Exception e) {
		
		}
	}
	
}
