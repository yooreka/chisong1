
public class if2 {

	public static void main(String[] args) {
		java.util.Scanner cs = new java.util.Scanner(System.in);
		int a = cs.nextInt();
//정수 하나를 입력받음
		if (a % 2 == 0) {
			System.out.print("짝수");
//2의배수라면 짝수
		} else {
			System.out.print("홀수");
	//그렇지 않으면 
		cs.close();}

	}
}
