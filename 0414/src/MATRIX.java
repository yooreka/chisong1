
public class MATRIX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] ar = { { 12, 24, 30 }, { 7, 24, 45 } };
		// 배열 요소 1개에 접근 : 배열이름[행번호] [열번호]
		// 1행 2열 데이터 출력
		System.out.println(ar[1][2]);
		// 데이터 개수 파악
		System.out.println("ar:" + ar.length);
		System.out.println("ar[0]:" + ar[0].length);
		// 모든 데이터를 열 우선으로 접근
		// 행의 개수 찾기
		int cntrow = ar.length;
		for (int i = 0; i < cntrow; i = i + 1) {
			// 각행에 해당하는 배열의 데이터 개수 찾기(열개수)
			int cntCol = ar[i].length;
			for (int j = 0; j < cntCol; j = j + 1) {
				System.out.println(ar[i][j]);
			}

		}
System.out.println("---------------------------------");
	int cntCol = ar[0].length;
	//2개의 반복문이 있는 경우 순서를 바꾸면 행과 열이 교체
	for(int j = 0; j<cntCol; j = j + 1) {
		for(int i = 0; i<cntrow; i = i +1) {
			System.out.println(ar[i][j]);
		}
	}
	 System.out.println("===========구구단=======");
	for(int i = 2; i<=9; i = i + 1) {
		
	}
	}
}