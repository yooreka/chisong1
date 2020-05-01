import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MovieDTORead {

	public static void main(String[] args) {

		//인스턴스 단위로 기록한 파일 읽기
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("2020-05-01.dat"))){
			ArrayList<MovieDTO> list = (ArrayList<MovieDTO>)ois.readObject();
		for(MovieDTO dto : list) {
			System.out.println(dto);
		}
		}catch(Exception e) {System.out.println(e.getMessage());}
	}

}
