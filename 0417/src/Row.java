
public class Row {

	public static int sequence = 1;
	
private int num;
private String name;
public Row() {
	super();
	num = sequence;
	sequence = sequence + 1;
}
public Row(int num, String name) {
	super();
	this.num = num;
	this.name = name;
}
public static int getSequence() {
	return sequence;
}
public static void setSequence(int sequence) {
	Row.sequence = sequence;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

	
	
}
