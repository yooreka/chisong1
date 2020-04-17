
public class Crabmain {

	public static void main(String[] args) {
		// crab클래스 인스턴스 만들기
		Crab c1 = new Crab();
		c1.setName("킹크랩");
		c1.setCash(70000);
		c1.setArea("china");

		Crab c2 = new Crab();
		c2.setName("robstar");
		c2.setCash(60000);
		c2.setArea("norway");

		// c2의cash를 가져와서 20000을 더한후 다시설정. 값을 설정할때는 set, 가져올때는 get
		int temp = c2.getCash();
		c2.setCash(temp + 20000);

		Crab c3 = new Crab();
		c3.setProperty("대개", "강원도", 50000);
		c3.display();
		c2.display();
		c1.display();
       
		Crab c4 = new Crab();
c4.setProperty("홍게", "동해");
c4.display();
	
	}

}
