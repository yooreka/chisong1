
public class Membermain {

	public static void main(String[] args) {
 Member per  = new Member();
         System.out.println(per.getId());
         
          Member per1 = new Member();
          per1.setId("tnwjd84");
          per1.setPw("tnwjddl1");
          per1.setName("인수정");
         //매개변수가 있는 생성자를 호출해서 인스턴스를 생성
          Member per3 = new Member("tnwjd84","1111","인수정");
         
	}

}
