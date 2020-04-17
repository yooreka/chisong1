
public class Testmain {

	public static void main(String[] args) {
		//Testclass 에 존재하는 static int norecuresionFibo(int n)사용
		int result = TestClass.noRecuresionFibo(9);
        System.out.println("9번째숫자:" + result);
       
        
	
        TestClass obj = new TestClass();
        result = obj.recursiveFibo(10);
        System.out.println("10번째숫자:" + result);
	
	
	}

}
