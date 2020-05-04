import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			//서버 소켓 생성 - 192.168.0.200:9999
			ServerSocket ss = 
				new ServerSocket(9990);
			while(true) {
				System.out.println("서버 대기 중...");
				//클라이언트의 요청을 기다림
				Socket socket = ss.accept();
				//전송된 메시지 읽기
				BufferedReader br = 
					new BufferedReader(
						new InputStreamReader(
							socket.getInputStream()));
				String msg = br.readLine();
				System.out.println("보낸 곳:" +
						socket.getInetAddress());
				System.out.println(msg);
				br.close();
				
				//받은 메시지 돌려보내기
				PrintWriter pw = 
					new PrintWriter(
						socket.getOutputStream());
				pw.println("반사:" + msg);
				pw.flush();
				pw.close();
				
				//socket.close();
				
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
