
public class toggl34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i <= 4; i = i + 1) {
			if (i <= 2) {
				for (int j = 0; j <= 3 - i; j = j + 1) {
					System.out.print(" ");
				}

				for (int j = 0; j <= i; j = j + 1) {
					System.out.print("*");

				}System.out.print("\n");
			} else {
				for (int k = 0; k <= i - 1; k = k + 1) {
					System.out.print(" ");
				}
				for (int k = 0; k <= 4 - i; k = k + 1) {
					System.out.print("*");
				}
				System.out.print("\n");
			}
		}
		
	}
}