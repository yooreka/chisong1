package templet;

public class Main {

	public static void main(String[] args) {
		Service service = new ServiceImpi();
		 boolean result = 
				 service.ticketing("root", "1234");
		 if(result == true) {
			 System.out.println("티켓 구입 성공");
			 
		 }else {
			 System.out.println("티켓 구입 실패");
		 }

	}

}
