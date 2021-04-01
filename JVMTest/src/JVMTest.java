public class JVMTest {

    public static final int A = 123;
    public static JVMTest jvmTest = new JVMTest();
    public int compute(){
        int a = 1;
        int b = 2;
        int c = a + b;
//        System.out.println(c);
        return c;
    }

    public static void main(String[] args) {
        JVMTest demo = new JVMTest();
        int n=demo.compute();
        System.out.println(n);
        System.out.println("DONE");
    }
}