import java.util.Scanner;

public class toggle {

	public static void main(String[] args) {
		// toggle(교번) - 2개의 상태를 번갈아가면서 변경
		// 2로 나눈 나머지 이요하거나 변수만들어서 변수상태변환 이용
		// enter를 누를 때마다 on 과 off를 수행하는처리
		/*
		 * Scanner sc = new Scanner(System.in); boolean flag = false; while(true ) {
		 * System.out.println("Enter를 누르세요:"); sc.nextLine(); if(flag == false) {
		 * System.out.println("on");
		 * 
		 * }else { System.out.println("off"); } flag = !flag;
		 */

		for(int i = 0; i <= 4; i = i + 1) {
			for(int j = 0; j <=-1*i+4; j = j + 1) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
		

	}
	
}
