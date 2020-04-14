
public class toggl34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i <= 4; i = i + 1) {
			if (i <= 2) {
				for (int j = 0; j <= 3 - i; j = j + 1) {
					System.out.print(" ");
				}

			}
			for (int j = 0; j <= i; j = j + 1) {
				System.out.print("*");

				}
			
				{for(int h = 0; h <= i - 1; h = h + 1){
				System.out.print(" ");
			}
			for (int h = 0; h <= 3 - i; h = h + 1) {
				System.out.print("*");
			}
		}
		System.out.print("\n");

		}
	}
}

