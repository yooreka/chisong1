import java.net.InetAddress;
import java.net.UnknownHostException;

public class NaverIPMain {

	public static void main(String[] args) {

		try {
			InetAddress [] naver = InetAddress.getAllByName("www.google.com");
			
			for(InetAddress imsi : naver) {
				System.out.println(imsi);
			}
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		
		}
		
	}

}
