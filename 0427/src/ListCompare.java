import java.util.ArrayList;
import java.util.LinkedList;

public class ListCompare {

	public static void main(String[] args) {
		// 문자열을 저장하는 arraylist와linkedlist생성
		ArrayList<String> ai = new ArrayList<>();

		LinkedList<String> li = new LinkedList<>();
		// 데이터를 2개씩 삽입
		ai.add("First");
		ai.add("Third");

		li.add("First");
		li.add("Third");
		// 1번째 자리에 second 문자열을 10만개 삽입하고 시간을 측정
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			ai.add(1, "Second");
		}

		long end = System.nanoTime();
		System.out.println("ArrayList : " + (end - start));

		start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			li.add(1, "Second");
		}

		end = System.nanoTime();
		System.out.println("ArrayList : " + (end - start));

	}

}
