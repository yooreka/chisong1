package Thread4;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadEx implements Runnable {
	public int result = 0;
	public int idx = 0;

	// idx를 10000번 증가시키면서 result에 더하기
   static ReentrantLock Lock = new ReentrantLock();
	public void sum() {
		for (int i = 0; i < 10000; i++) {
		    Lock.lock();
			//synchronized(this) {
			idx = idx + 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
			result = result + idx;
		Lock.unlock();	
		}
		}
	//}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		sum();
	}
}
