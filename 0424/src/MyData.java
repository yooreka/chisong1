
public class MyData {
//이름 , 나이, 연봉을 저장하는 클래스

	
	//저장프로퍼티, constructor, getter&setters, toString
	private String name;
private int age;
private int money;
//생성자
public MyData() {
	super();
	// TODO Auto-generated constructor stub
}
public MyData(String name, int age, int money) {
	super();
	this.name = name;
	this.age = age;
	this.money = money;
}
//접근자 메소드
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
@Override
public String toString() {
	return "MyData [name=" + name + ", age=" + age + ", money=" + money + "]";
}





}
