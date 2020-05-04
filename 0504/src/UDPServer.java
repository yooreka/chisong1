import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
         try {
        	 
        	 //UDP받는 소켓 생성
        	 DatagramSocket ds = new DatagramSocket(9003);
        	 while(true) {
                         System.out.println("서버 대기 합니다.");
                         //받은 데이터를 저장할 배열
                         byte [ ] data = new byte[300];
                        //데이터 받기
                         DatagramPacket dp = new DatagramPacket(data, 300);
                         ds.receive(dp);
                        		 // 보낸 곳의 주소와 내용 출력
                        System.out.println("보낸곳:" + dp.getAddress().getHostAddress() );
                        //바이트 배열을 문자열로 만들기
                        String msg = new String(data);
                        System.out.println("보낸 메시지:" + msg);
        	 }
        
         
         
         }catch(Exception e) {
        	 System.out.println(e.getMessage());
        	 e.printStackTrace();
         }

	}

}
