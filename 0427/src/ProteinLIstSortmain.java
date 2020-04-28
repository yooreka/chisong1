import java.util.ArrayList;
import java.util.Comparator;

public class ProteinLIstSortmain {

	public static void main(String[] args) {
		// data 여러 개 저장하는 ArrayList를 생성
		ArrayList<ProteinClass> pc = new ArrayList<>();

		// 데이터추가
		pc.add(new ProteinClass(11115556, 500, 30, 2021, "초코", "신타6"));
		pc.add(new ProteinClass(11115555, 400, 30, 2022, "초코", "지웨이"));
		pc.add(new ProteinClass(11115554, 450, 27, 2023, "초코", "CGN"));

		pc.sort(new Comparator<ProteinClass>() {

			@Override
			// 맛이 똑같으면 유통기한으로 내림차순
			public int compare(ProteinClass o1, ProteinClass o2) {
				if (o1.getTaste().compareTo(o2.getTaste()) == 0) {
					return o1.getTaste().compareTo(o2.getTaste());
				} else {
					return o1.getDate() - o2.getDate();
				}
			}

		});
		for (ProteinClass Pc : pc) {
			System.out.println(pc);
		}

	}

}