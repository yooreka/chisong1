package datashare;

public class sharedata {
//static이 없는 프로퍼티라서 인스턴가 각자 소유
	public String noShare;
	//static이 있어서 클래스에 만들고 인스턴스가 공유
	public static String msg;

	public void globalchange() {
		gloverclass.yoo = "전역 변수 수정";
	}


}
