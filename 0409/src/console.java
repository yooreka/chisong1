
public class console {

	public static void main(String[] args) {
	

		java.util.Scanner cs = new java.util.Scanner(System.in);
	 
	
		System.out.println("��й�ȣ �Է�");

		 int number = cs.nextInt();
	
		 System.out.println(number);
		
		cs.nextLine();
		
  
				
		
		System.out.println("ID�Է�");
		
      	String name = cs.nextLine();
	
	System.out.println(name);
		
		
		System.out.println(name  + ":" + number );
		
				cs.close();
		
	
		
	}

}
