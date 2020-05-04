import java.io.File;
import java.util.Date;

public class FileInfo {

	public static void main(String[] args) {
		//파일에 대한 정보를 리턴해주는 File 인스턴스 생성
		File file = new File("c:\\Users\\30414\\chisong\\0428\\src\\PrimeCheck.java");

		//파일의 마지막 수정 날짜 확인
		long lastModified = file.lastModified();
		Date date = new Date(lastModified);
		
		System.out.println(date);
		//파일의 크기 확인
		long length = file.length();
		System.out.println(length/1024 + "KB");
	
	}

}
