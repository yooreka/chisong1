package thread5;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Producer th1 = new Producer();
      th1.start();
	
	Customer th2 = new Customer();
	th2.start();
	
	}

}
