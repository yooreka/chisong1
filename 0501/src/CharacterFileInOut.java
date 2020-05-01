import java.io.FileReader;
import java.io.FileWriter;

public class CharacterFileInOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //()안에서 만든 것은 close()를 호출하지 않아도 자동종료
		//{}안에서 만든것은 close()를 호출해야 종료가 됩니다
		//close()를 호출하지 않으면 파일이 읽기 전용이 될수 있음
	try(FileWriter fw = new FileWriter("C:\\Users\\30414\\chisong\\0501/ch.txt")){
		//기록하고자하는 문자열생성
		String msg = "문자단위로기록하기";
		fw.write(msg);
		fw.flush();
	}catch(Exception e) {
		//예외 내용출력
		System.out.println(e.getMessage());
		//예외 발생지점 역추
		e.printStackTrace();
	}
	try(FileReader fr = new FileReader("C:\\Users\\30414\\chisong\\0501/ch.txt")){
		char [ ] buf = new char[512];
		fr.read(buf);
		System.out.println(new String(buf));
	}catch(Exception e) {
		//예외 내용출력
		System.out.println(e.getMessage());
		//예외 발생지점 역추
		e.printStackTrace();
	}
	
	}

}
