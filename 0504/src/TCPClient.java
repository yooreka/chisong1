import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
			//통신하려면 소켓 필요  > 만들기
		  InetAddress addr =
				  InetAddress.getByName("192.168.0.50");
		 Scanner sc= new Scanner(System.in);
		  while(true) {
			  //소켓연결
			  Socket socket = new Socket(addr, 9990
					  );
		  System.out.print("메세지:");
		 String msg = sc.nextLine();
		 //메세지 전송
		 PrintWriter pw = new PrintWriter(socket.getOutputStream());
		 pw.println(msg);
		 pw.flush();
		 pw.close();
		  
		  
		  //메세지 읽기
		  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		 String receiveingmsg = br.readLine();
		 System.out.println(receiveingmsg);
		 br.close();
		  }
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
