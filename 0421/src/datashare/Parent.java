package datashare;

public class Parent {
       public String parentVar;
       
       //Parent 클래스 안에서 Child 클래스의 인스턴스를 생성 
       //이런경우를 has a관계 , 포함관계라고함
       
       
       public Child child;
       public Parent() {
    	  
    	   //포함하고 있는 인스턴스의 데이터를 포함된 인스턴스에서 사용하고자 할 때는 
    	  //포함된 인스턴스를 만들 때 생성자에 데이터를 넘겨주면 됩니다.
    	   child = new Child(parentVar);
      child.childVar = "부모에서 자식을 설정";
      child.disp();
       
       
       }
       
}
