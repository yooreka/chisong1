
public class toggle3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i <= 4; i = i + 1) {
			for (int j = 0; j <= 3 - i; j = j + 1) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j = j + 1) {
				System.out.print("*");
			}
			System.out.print("\n");

		}

	}

}
