import java.io.PrintWriter;

public class CaracterBufferWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(PrintWriter pw = new PrintWriter("./pw.txt")){
			pw.println("문자 단위로 버퍼를 이용해서 기록");
			pw.flush();
		}catch(Exception e) {
			
		}
		
		
		
	}

}
