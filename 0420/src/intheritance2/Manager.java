package intheritance2;
//employee클래스를 상속받는 Manager클래스
public class Manager extends emplpyee {
    //직급을 저장할 프로퍼티
	private String rank;

public Manager(String empName, String empPart, String rank) {
	//상위클래스의 생성자 호출
	super(empName, empPart);
	this.rank  =rank;
}


	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	//문자열을 만들어서 리턴하는 메소드
	public String managerStr() {
		//상위 클래스에 만든 resultStr()호출
		String result = resultStr();
		result = result + "직급:" + rank;
		return result;
	}
}
