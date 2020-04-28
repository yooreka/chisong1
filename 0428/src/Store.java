
//가게코드(문자열), 가게이름(문자열), 평점(실수)//최소주문금액(정수),메뉴(문자열)

public class Store {

	private String code;
	private String name;
	private double average;
	private int minOrderMoney;
	private String menu;
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Store(String code, String name, double average, int minOrderMoney, String menu) {
		super();
		this.code = code;
		this.name = name;
		this.average = average;
		this.minOrderMoney = minOrderMoney;
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Store [code=" + code + ", name=" + name + ", average=" + average + ", minOrderMoney=" + minOrderMoney
				+ ", menu=" + menu + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public int getMinOrderMoney() {
		return minOrderMoney;
	}
	public void setMinOrderMoney(int minOrderMoney) {
		this.minOrderMoney = minOrderMoney;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}






}

