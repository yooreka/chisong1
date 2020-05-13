
public class SoccerTeam {
	
      private  String NAME; 
      private   int  WIN; 
      private   int  LOSE;
      private   int  DRAW; 
      private   int  SCORE; 
      private   int  RUNS;
	
      //생성자 - 인스턴스를 생성하기 위해서 호출하는 메소드 new로 호출
      public SoccerTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SoccerTeam(String nAME, int wIN, int lOSE, int dRAW, int sCORE, int rUNS) {
		super();
		NAME = nAME;
		WIN = wIN;
		LOSE = lOSE;
		DRAW = dRAW;
		SCORE = sCORE;
		RUNS = rUNS;
	}
	//접근자  메소드
	public String getNAME() {
		return NAME;
	}
	@Override//디버깅을 빠르게 하기 위한 메소드
	public String toString() {
		return "SoccerTeam [NAME=" + NAME + ", WIN=" + WIN + ", LOSE=" + LOSE + ", DRAW=" + DRAW + ", SCORE=" + SCORE
				+ ", RUNS=" + RUNS + "]";
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getWIN() {
		return WIN;
	}
	public void setWIN(int wIN) {
		WIN = wIN;
	}
	public int getLOSE() {
		return LOSE;
	}
	public void setLOSE(int lOSE) {
		LOSE = lOSE;
	}
	public int getDRAW() {
		return DRAW;
	}
	public void setDRAW(int dRAW) {
		DRAW = dRAW;
	}
	public int getSCORE() {
		return SCORE;
	}
	public void setSCORE(int sCORE) {
		SCORE = sCORE;
	}
	public int getRUNS() {
		return RUNS;
	}
	public void setRUNS(int rUNS) {
		RUNS = rUNS;
	} 

}
