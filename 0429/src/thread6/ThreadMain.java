package thread6;

public class ThreadMain {

	public static void main(String[] args) {
           for(int i=0; i<10; i++) {
        	   ThreadEx th = new ThreadEx();
        	   th.start();
           }
	}

}
