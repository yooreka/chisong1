package overridingintheritance3;

public class Main {

	public static void main(String[] args) {
		//emplyee인스턴스 생성
		//어떤 클래스의 인스턴스를 1개만 만드는 경우
		//인스턴스의 참조를 저장할 변수를 클래스의 이름과 동일하게첫글자만 소문자로 하는 경우가 많음
		emplpyee emplpyee = new emplpyee();
		emplpyee.setEmpName("손흥민");
        emplpyee.setEmpPart("토트넘");                             //(데이터가 없을때)
	
        System.out.println(emplpyee.resultStr());
        
        //Manager 클래스의 인스턴스를 생성하고 값을 대입
        Manager manager = new Manager();
        manager.setEmpName("포치");
        manager.setEmpPart("토트넘");
       manager.setRank("감독");

       System.out.println(manager.resultStr());
        //employee 인스턴스를 1개 더 생성하고 값을 대입
      emplpyee emp1 = new emplpyee("이강인", "발렌시아");  //(데이터가 이미 있을때 바로바로)
      System.out.println(emp1.resultStr());
      
	
	}

}
