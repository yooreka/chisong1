import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastClient {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("닉네임 :");
			String nickname = sc.nextLine();
			// 메세지 보낼 곳의 ip주소만드릭
			InetAddress ip = InetAddress.getByName("FF01:0:0:0:0:0:0:175");
			// 보낼곳의 포트번호
			int port = 9999;
			// 보낼 소켓 생성
			MulticastSocket ms = new MulticastSocket();
			while (true) {
				System.out.print("보낼 메세지:");
				String msg = sc.nextLine();
				msg = nickname + ":" + msg;

				DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, port);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}