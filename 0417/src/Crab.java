
public class Crab {
	// 이름, 서식지, 가격
	// 인스턴스가 직접 핸들링 할 수 없도록 private으로 생성
	private String name;
	private String area;
	private int cash;
	// 전체 제목으로 사용할 변수를 생성
	// 전체제목으로 사용할 변수 생성
	// 전체가 공통된 이름을 사용하기 때문에 static 변경 할 수 없도록 final
	private static final String title = "갑각류 종류";

	// 프로퍼티를 private로 만들어서 인스턴스가 사용 못 하기 때문에 인스턴가 사용 할 수 있도록 접근자 메소드를 만들어야함
	// 접근자 메소드 - getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public static String getTitle() {
		return title;
	}

//이름, 원산지 ,가격을 받아서 set하는 메소드

	public void setProperty(String name, String area, int cash) {
		// 메소드의 매개변수가 name, area, cash
		// 프로퍼티의 이름도 name, area, cash
//메소드 안에서 만든 지역변수가 아닌 프로퍼티를 가져올 때는 this.을 붙여서 가져오면 됩니다 this를 생략하면 메소등 안에서 찾고 없으면 프로퍼티로감
		this.name = name;
		this.area = area;
		this.cash = cash;

	}
	//이름과 원산지만 입력받고 가격은 0으로 설정하는 메소드
	//위에 String, String, int를 매개변수로 하는 setProperty가 이미 존재 .String, int를 매개변수로 받는 setProperty 이런경우를 MethodOverloading
	public void setProperty(String name, String area) {
		this.name = name;
		this.area = area;
		this.cash = 0;
		
	}
//이름과 원산지 가격을 출력하는 메소드
	public void display() {
		System.out.println("이름:" + name +"원산지:" + area +"가격 :" + cash + "원(단위-만원)");
	}
}
