package thread5;

public class Customer extends Thread {
	// 공유자원을 소비하는 메소드
	public synchronized void get() {
		// 사용할 자원이 없으면 대기
		if (ShareData.List.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 첫번째 데이터삭제
		String msg = ShareData.List.remove(0);
		System.out.println(msg + "소비");

	}

}
