import java.util.ArrayList;
import java.util.Comparator;

public class ListSortMain {

	public static void main(String[] args) {
		// 정수 데이터를 저장할 수 있는 ArrayList 생성
		ArrayList<Integer> list = new ArrayList<>();

		list.add(65);
		list.add(15);
		list.add(35);
		list.add(25);
		// 데이터 오름차순 정렬
		list.sort(new Comparator<Integer>() {

			@Override
			// 숫자 데이터의 경우는 앞의 데이터에서 뒤의 데이터를
			// 뺄셈한 결과를 리턴하면 오름차순 정렬
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}

		});
		// 결과확인
		System.out.println(list);
		// 문자열을 저장하는 ArrayList를 생성
		ArrayList<String> list1 = new ArrayList<>();
		// 데이터를 추가
		list1.add("손흥민");
		list1.add("Lee강인");
		list1.add("body");
		list1.add("손웅정");
		list1.add("기성용");

		// 데이터를 내림차순 정렬
		list1.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				// String 과 Data는 compareTo 메소드를 이용해 크기비교
				// 앞의 데이터를 기준으로 비교 : 오름차순
				// 뒤의 데이터를 기준으로 비교 : 내림차순
				// 알고리즘에서는 비교하는 부등호의 방향을 반대로
				return o2.compareTo(o1);

			}

		});

		// 전체 데이터를 확인
		System.out.println(list1);

	}

}
