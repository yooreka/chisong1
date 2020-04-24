import java.util.Arrays;
import java.util.Comparator;

public class MyDataMainSorting {

	public static void main(String[] args) {

		MyData[] ar = new MyData[3];
		MyData pr1 = new MyData();
		pr1.setName("유치송");
		pr1.setAge(27);
		pr1.setMoney(50000000);
		ar[0] = pr1;

		ar[1] = new MyData();
		ar[1].setName("강경원");
		ar[1].setAge(46);
		ar[1].setMoney(1000000000);

		ar[2] = new MyData();
		ar[2].setName("정봉길");
		ar[2].setAge(35);
		ar[2].setMoney(10000000);

		// 정렬
		// ar은UserData의 배열이고 UserData는 Comparable 인터페이스가 implements 되지 않아서
		// 크기 비교하는 방법을 알지 못하기 때문임
		Comparator<MyData> comp1 = new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				MyData o3 = (MyData) o1;
				MyData o4 = (MyData) o2;
				return o3.getName().compareTo(o4.getName());

			}

		};

		Arrays.sort(ar, comp1);

		// 배열의 데이터 전부 출력
		for (MyData temp : ar) {
			System.out.println(temp);
		}

	}

}
