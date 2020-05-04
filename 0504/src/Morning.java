import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Morning {

	public static void main(String[] args) {
     try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\\\Users\\\\30414\\\\Desktop\\\\log.txt")))){
     HashSet<String> set = new HashSet<>();
    	 int total = 0;
    	 
    	 while(true) {
    		 String line = br.readLine();
    		 if(line == null) {
    			 break;
    		 }
    	
    	 String [ ]data = line.split(" ");
    	 
    	set.add(data[9]);
    	 
    	 } 
     
    		 
    	 
    	 }
    	 
    	 
    	 
    	 
     }catch(Exception e) {
    	 System.out.println(e.getMessage());
     }
     
	}

}
