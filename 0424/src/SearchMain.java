import java.util.Arrays;

public class SearchMain {

	public static void main(String[] args) {
       String [] soccers = {"루니","호날두","박지성","손흥민"};
       
       //데이터정렬
       Arrays.sort(soccers);
       
       System.out.println(Arrays.binarySearch(soccers, "루니"));
       System.out.println(Arrays.binarySearch(soccers, "베르바토프0"));
	
       String [] alphabets = {"Ronaldo", "Pakr", "koo"};
       
       String [] imsi = new String[alphabets.length];
       
       for(int i = 0; i<imsi.length; i++) {
    	   //원본 데이터를 복사해서 복사본 배열에 저장
    	   imsi[i] = alphabets[i].toUpperCase();
    	   }
	
	Arrays.sort(imsi);
	  for(String soccer : imsi) {
		  System.out.println(soccer);
	  }
	
	
	}
	
	
	

}
