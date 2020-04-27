import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
    Stack <String> stack = new Stack <>();
	//스텍에 데이터 삽입
    stack.push("Stive rogers");
    //스택에서 데이터를 꺼내기
    String data = stack.pop();
    System.out.println(data);
   //스택에 데이터가 없는데 꺼낼려고 해서 예외가 발생
    data = stack.pop()
;	}

}
