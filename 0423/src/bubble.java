
public class bubble {

	public static void main(String[] args) {
	int [ ] ar = {10, 30, 20, 15, 5};
	int t = 5;
	for( int i = 0; i <ar.length; i++) {
		for(int j = 1; j < ar.length -1; j++) {
			if(ar[i] > ar[j]) {
				int temp = ar[i];
				ar[i] =ar[j];
				ar[j] = temp;
				
			}
		}
	}

	}

}
