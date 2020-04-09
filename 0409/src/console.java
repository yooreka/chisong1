
public class console {

	public static void main(String[] args) {
	

		java.util.Scanner cs = new java.util.Scanner(System.in);
	 
	
		System.out.println("비밀번호 입력");

		 int number = cs.nextInt();
	
		 System.out.println(number);
		
		cs.nextLine();
		
  
				
		
		System.out.println("ID입력");
		
      	String name = cs.nextLine();
	
	System.out.println(name);
		
		
		System.out.println(name  + ":" + number );
		
				cs.close();
		
	
		
	}

}
