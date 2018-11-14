package in.amt.practice.simple;

/**
 * Created by amit.sharma5 on 13/11/18.
 */
public class A {

    /**
     * this will be called when instance of A is created or instance of B is created
     */
    A(){
        System.out.println("A");
    }
    A(String a){
        System.out.println(a);
    }
}
class B extends A{
    B(){
        System.out.println("B");
    }
    B(String b){
        System.out.println(b);
    }
}

class Main{
    public static void main(String[] args) {
        A a = new A();
        A a1 = new A("amit");
        A b = new B();
        A b1 = new B("amit");
    }
}