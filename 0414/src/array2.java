
public class array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = { 88, 50, 65, 80, 25, 65 };
		// 60이 넘는 데이터의 합계, 개수, 평균을 구하기
		// 평균은 소수 첫째 자리에서 반올림해서 정수로 저장
		int len = data.length;
		int sum = 0;
		// 데이터 개수를 저장할 변수
		int cnt = 0;

		for (int i = 0; i < len; i = i + 1) {
			// 60이상인경우
			if (data[i] >= 60) {
				sum = sum + data[i];
				cnt = cnt + 1;
			}

		}
		System.out.println("합계 : " + sum);
		System.out.println("개수 : " + cnt);
		if (cnt == 0) {
			System.out.println("조건에맞는 데이터가 없습니다");
		} else {
			int avg = (int) ((double) sum / cnt + 0.5);
			System.out.println("평균:" + avg);
		}
		// 최대 최소 구하기
		// 데이터가 0에서 100사이라고 가정한 경우
		int max = data[0];
		int min = data[0];

		for (int i = 0; i < len; i = i + 1) {
			if (max < data[i]) {
				max = data[i];
			}
			if (min > data[i]) {
				min = data[i];
			}

		}
		System.out.println("최대값:" + max);

		System.out.println("최소값:" + min);
		max = data[0];
		int idx = 0;

		for (int i = 0; i < len; i = i + 1) {
			if (max < data[i]) {
				max = data[i];
				idx = i;
			}
			System.out.println(max + "위치는" + idx);
		}
		min = 1000000;// 최소값을 아주 큰 값으로 초기화
		// 거리의 최소값을 저장하기 위한 변수
		int distanceMin = 100000000;//2 큰숫자아무거나써도됨
		// 거리의 최소값 위치를 저장할 인덱스
		idx = -1;//위치로볼 때는 0도이미가있음 통상적으로 -1로함
		for (int i = 0; i < len; i = i + 1) {
			// 거리계산
			int distance = 77 - data[i];
			// 거리가 음수이면 양수로변환 
			if (distance < 0) {
				distance = -distance;

			} // 거리의 최소값보다 작은 거리를 만나면
			if (distanceMin > distance) {
				// 거기를 거리의 최소값에 대입
				distanceMin = distance;
				// 데이터를 min에 대입
				min = data[i];
				// 인덱스를 idx에 대입
				idx = i;
			}
		}
		System.out.println("77과 가장 가까운 값:" + min);
	}

}
