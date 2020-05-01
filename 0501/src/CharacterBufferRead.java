import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CharacterBufferRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./0428.txt")))){
			while(true) {
		
			String msg = br.readLine();
			if(msg == null) {
				break;
			}
			System.out.println(msg);}
		}catch(Exception e) {
			
		}
		
	}

}
