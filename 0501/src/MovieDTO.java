import java.io.Serializable;

public class MovieDTO implements Serializable {
 /*데이터를 구성할 프로퍼티를 private 로 선언예매율 19.3%  97% (실관람평 : 175,754명)
	감독 : 안소니 루소 ,  조 루소
	장르 : 액션, SF / 기본 : 
	12세 이상, 181분, 미국
	개봉 :*/ 
	
	private String director;
	private String type;
	private String contry;
	private double reserve;

	//이번 작업은 대부분 데이터베이스를 사용하기 전에만 수행
	//인스턴스를 빠르게 만들기 위한 생성자 추가
	public MovieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieDTO(String director, String type, String contry, double reserve) {
		super();
		this.director = director;
		this.type = type;
		this.contry = contry;
		this.reserve = reserve;
	}
  //접근자 메소드 - getter & setter
	//프로퍼티를 private로 선언했기때문에 인스턴스가 직접 접근이 안되서 프로퍼티에 접근하기 위해서 만든 메소드
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public double getReserve() {
		return reserve;
	}

	public void setReserve(double reserve) {
		this.reserve = reserve;
	}
//디버깅을 위한 메소드
	//이메소드를 만들지 않으면 인스턴스 이름을 가지고 인스턴스를 출력할때 클래스이름과 해시코드가 리턴
	//프로퍼티의 값을 빠르게 확인하기 위해서 만드는 메소드
	@Override
	public String toString() {
		return "MovieDTO [director=" + director + ", type=" + type + ", contry=" + contry + ", reserve=" + reserve
				+ "]";
	}
	
}
