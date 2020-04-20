package overridingintheritance3;
//employee클래스를 상속받는 Manager클래스
public class Manager extends emplpyee {
    //직급을 저장할 프로퍼티
	private String rank;

	public Manager() {
		super();
		//private 는 상속이 되더라도 하위 클래스에서 접근이 안됨
		//auto_increment = auto_increment + 1; public으로 바꾸면 접근 가능
	}

	public Manager(String empName, String empPart) {
		super(empName, empPart);
		// TODO Auto-generated constructor stub
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	//Method Overriding
	//문자열을 만들어서 리턴하는 메소드
	public String resultStr() {
		//상위 클래스에 만든 resultStr()호출
		String result = super.resultStr();
		result = result + "직급:" + rank;
		return result;
	}
}
