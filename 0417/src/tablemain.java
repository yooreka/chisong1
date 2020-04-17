
public class tablemain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//3개의 Row 데이터를 저장할 배열을 생성
		Row [] ar = new Row[3];
		//기본형 배열이 아니므로 인스턴스를 직접 생성해서 대입
		ar[0] = new Row();
		ar[0].setName("하정우");
		
		ar[1]= new Row();
		ar[1].setName("이병헌");
		
		ar[2] = new Row();
		ar[2].setName("송강호");
		//배열의 데이터 출력
		for(int i = 0; i<ar.length; i = i + 1) {
			Row imsi = ar[i];
			System.out.println(imsi.getNum() + ":" + imsi.getName());
		}
		
	}

}
