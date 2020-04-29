package thread5;

public class Producer extends Thread {
  //공유 데이터에 데이터를 저장하는 메소드
	public synchronized void  put(String data) {
		ShareData.List.add(data);
	   //wait중인 스레드 중에서 1개를 깨워서 실행하도록
		//해주는 메소드
		notifyAll();
	
	//스레드로 동작할 메소드
			
	}
	public void run() {
		try {
			for(int i=0; i<10; i++) {
			Thread.sleep(1000);
			get();
			System.out.println("Data" + i + " 생산");
			}
				
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private void get() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
