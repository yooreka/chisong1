
public class ProteinClass {
//클래스만들어보기
	// 일련번호  보충제 용량  //단백질 함량  //유통기한 //맛  //보충제 이름 
	private int num;
	private int serving;
	private int gram;
	private int date;
	private String taste;
	private String name;
	public ProteinClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProteinClass(int num, int serving, int gram, int date, String taste, String name) {
		super();
		this.num = num;
		this.serving = serving;
		this.gram = gram;
		this.date = date;
		this.taste = taste;
		this.name = name;
	}
	//디버깅을위해 논리적인오류나 예외를 해결하기위해
	@Override
	public String toString() {
		return "ProteinClass [num=" + num + ", serving=" + serving + ", gram=" + gram + ", date=" + date + ", taste="
				+ taste + ", name=" + name + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getServing() {
		return serving;
	}
	public void setServing(int serving) {
		this.serving = serving;
	}
	public int getGram() {
		return gram;
	}
	public void setGram(int gram) {
		this.gram = gram;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
