
public class main {

	public static void main(String[] args) {
	
 int idx = 0;
 while(true) {
	int mod = idx % 7;
	if(mod==0)
	          System.out.println("��");
	else if(mod==1)
		 System.out.println("ȭ");
	else if(mod==2)
		 System.out.println("��");
	else if(mod==3)
		 System.out.println("��"); 
	else if(mod==4)
		 System.out.println("��");
	else if(mod==5)
		 System.out.println("��");
	else if(mod==6)
		 System.out.println("��");
 try  {
	 Thread.sleep(1000);
    }catch(Exception e) {}
	
 
	idx++;
 }
 }
  }
	
