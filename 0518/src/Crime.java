
public class Crime {
private String categorize;
private int allcrime;
private int mentalcrime;
private double persent;
public Crime() {
	super();
	// TODO Auto-generated constructor stub
}
/*db연동을하기 떄문에 생성자 만들 필요없음
public Crime(String categorize, int allcrime, int mentalcrime, double persent) {
	super();
	this.categorize = categorize;
	this.allcrime = allcrime;
	this.mentalcrime = mentalcrime;
	this.persent = persent;
}*/
public String getCategorize() {
	return categorize;
}
public void setCategorize(String categorize) {
	this.categorize = categorize;
}
public int getAllcrime() {
	return allcrime;
}
public void setAllcrime(int allcrime) {
	this.allcrime = allcrime;
}
public int getMentalcrime() {
	return mentalcrime;
}
public void setMentalcrime(int mentalcrime) {
	this.mentalcrime = mentalcrime;
}
public double getPersent() {
	return persent;
}
public void setPersent(double persent) {
	this.persent = persent;
}
@Override
public String toString() {
	return "Crime [categorize=" + categorize + ", allcrime=" + allcrime + ", mentalcrime=" + mentalcrime + ", persent="
			+ persent + "]";
}
}
