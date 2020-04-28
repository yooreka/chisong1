import java.util.Scanner;
import java.util.TreeSet;

public class LottoSet {

	public static void main(String[] args) {

		TreeSet<Integer> lotto = new TreeSet<>();
		Scanner sc = new Scanner(System.in);

		while (lotto.size() < 6) {
			try {
				System.out.print("정수입력(1-45)");
				String input = sc.nextLine();
				int su = Integer.parseInt(input);
		
			//1부터 45까지 숫자가 아니면 입력다시
				if(su < 1 || su > 45) {
					System.out.println("1~45사이의 정수를 입력하세요");
				continue;
				}
			//set에 데이터 삽입
				boolean result = lotto.add(su);
				//삽입에 실패한 경우는 중복된 데이터를 삽입한 경우
				if(result == false) {
					System.out.println("중복된 데이터입니다.");
				}
			} catch (Exception e) {
				System.out.println("숫자를입력하세요");
			}

		}
      for(int temp : lotto) {
    	  System.out.println(temp + "\t");
      }
		
		
		sc.close();
	}

}
