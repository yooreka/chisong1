import java.util.Scanner;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc = new Scanner(System.in);
	System.out.println("년도를 입력 하세요");
	int year = sc.nextInt();
	System.out.println("달을 입력하세요");
	int month = sc.nextInt();
	System.out.println("날짜를 입력하세요");
	int day = sc.nextInt();
       sc.close();
       
       
     //입력받은 년도 이전까지 지나온 날들을 전부 더함
       int tot = 0;
      //윤년이면 366을 더하고 그렇지않으면 365더함
       for(int i = 1; i<year; i = i + 1) {
    	   if(i%4==0 && i%100!=0 || i%400==0) {
    		   tot = tot + 366;
    	   }else {
    		   tot = tot + 365;
    	   }
    	
       }
       
       //각월의 날짜 수를 갖는 배열을 생성
       int [] nalsu = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
       //입력한 년도가 윤년이면 2월은 29일 까지
       if(year%4==0 && year%100!=0 || year%400==0) {
    	   nalsu[2] = 29;
       }
          //입력한 월 이전 까지의 날 수를 전부 더함
       for(int i = 0; i<month; i = i + 1) {
    	   tot = tot + nalsu[i];
       }
   //입력 받은 일을 더함
       tot = tot + day - 1;
       //요일은 7번마다 1번씩 돌아오므로 7로 나눈 나머지 계산
       int result = tot % 7;
       
       String [] weekday = 
    	   {"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
       
     
	
	 System.out.println(weekday[result]);
	}

}
