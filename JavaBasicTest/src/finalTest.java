/**
 * java关键字final
 *
 * static作用于成员变量用来表示只保存一份副本，而final的作用是用来保证变量不可变。
 */

class MyClass {
    public int i = 0;
    public final double i1 = Math.random();
    public static double j = Math.random();
}
public class finalTest {

        public static void main(String[] args)  {
            String a = "hello2";
            final String b = "hello";
            String d = "hello";
            String c = b + 2;
            String e = d + "2";
            String g= new String("hello2");
            System.out.println((a == c));
            System.out.println((a == e));
            System.out.println((a == g));
            //final指向的对象内容可变
            final MyClass myClass = new MyClass();
            myClass.i=5;
            System.out.println(myClass.i);
            System.out.println(++myClass.i);
            finalAndStatic();
        }
    public static void finalAndStatic()  {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i1);
        System.out.println(MyClass.j);
        System.out.println(myClass2.i1);
        System.out.println(myClass2.j);

    }


}
