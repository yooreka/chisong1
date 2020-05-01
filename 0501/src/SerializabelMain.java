import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializabelMain {

	public static void main(String[] args) {
		//파일에 인스턴스 단위로 기록
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./oo.dat"))){
    	//DTo 클래스의 인스턴스를 생성
    	DTO dto = (DTO)ois.readObject();
    	//파일에기록
    	System.out.println(dto);
    }catch(Exception e) {
    	System.out.println(e.getMessage());
        e.printStackTrace();
    }
		
  	}

}
