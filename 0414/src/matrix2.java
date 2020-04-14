
public class matrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//전체 합꼐를 저장할 변수
		int[][] ar = { { 10, 20, 30 }, { 15, 25, 35 } };

		int sum = 0;
		// 행의 합계를 저장할 배열
		// sumRow[0], sumRow[1] 은 모두 0
		// 배열을 생성하고 데이터를 대입하지 안흥면
		// 0, false, null
		int[] sumRow = new int[ar.length];
		// 열의 합계를 저장할 배열
		int[] sumCol = new int[ar[0].length];
		// 전체 데이터 합계
		// 전체 데이터를 순회하면서 데이터를 sum에 더하면 됩니다.
		// 전체 데이터가 6개이고 2행 3열인 경우에
		// 하나의 반복문으로 전체 데이터를 접근
		for (int i = 0; i < 6; i = i + 1) {
			// 행번호는 열의 개수로 나눈 몫
			// 열번호는 열의 개수로 나눈 나머지
			// 이차원 배열을 만들어야 하는 경우 일차원 배열로 만들고 아래 접근 방법을 이용해서 행단위 구분을 하기도 한다.
			sum = sum + ar[i / 3][i % 3];
		}
		System.out.println("합계: " + sum);
		
			for (int i = 0; i < 2; i = i + 1) {
				for (int j = 0; j < 3; j = i + 1) {
					sumRow[i] = sumRow[i] + ar[i][j];

				}

			}
			// 행의 합계 배열의 내용을 출력

			int len = sumRow.length;
			for (int i = 0; i < len; i = i + 1) {
				System.out.println(sumRow[i]);
			

		}
		// 열단위 합계 구하기
		for (int j = 0; j < 2; j = j + 1) {
			for (int i = 0; i < 3; i = i + 1) {
				sumCol[j] = sumCol[j] + ar[i][j];
			}
		}
		System.out.println("열단위합계 : ");
		for (int i = 0; i < 3; i = i + 1) {
			System.out.println(sumCol[i]);
		}

	}

}