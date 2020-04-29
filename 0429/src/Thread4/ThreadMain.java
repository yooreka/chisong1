package Thread4;

public class ThreadMain {

	public static void main(String[] args) {

		ThreadEx obj = new ThreadEx();
		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		th1.start();
		th2.start();
		try {
			Thread.sleep(30000);
		} catch (Exception e) {
		}
		System.out.println(obj.result);

	}

}
