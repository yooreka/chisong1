import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //정수는 java.lang.Integer클래스
		int [ ]ar = {30, 60, 90, 20};
	
		//Arrays 의 sort 메소드가 정렬을 해 줌
		Arrays.sort(ar);
		for(int temp : ar) {
			System.out.printf(temp + "\t");
		}
		System.out.printf("\n");
		String [] br = {
				"신태일", "승냥이", "목정자", "섹용이", "짜이탄"};
		
	Arrays.sort(br);
	for(String temp : br) {
		System.out.printf(temp + "\t");
	}
	System.out.printf("\n");
	}
		
	}


