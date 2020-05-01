import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;

public class ByteBufferinout {

	public static void main(String[] args) {

		try (PrintStream ps = new PrintStream("./buf.txt")) {
			ps.write("버퍼를 이용한 기록".getBytes());
			ps.flush();

		} catch (Exception e) {
			// 예외 내용출력
			System.out.println(e.getMessage());
			// 예외 발생지점 역추
			e.printStackTrace();
		}
		// 버퍼 단위로 읽어오기
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./buf.txt"))) {
			byte[] b = new byte[512];
			bis.read(b);
			System.out.println(new String(b));

		} catch (Exception e) {
			// 예외 내용출력
			System.out.println(e.getMessage());
			// 예외 발생지점 역추
			e.printStackTrace();
		}
	}
}
