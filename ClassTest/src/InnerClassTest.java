/*
@author:HKJ
@Date:20212.3.29
 */
class Out {
    int  a=99;
    static int b=10;
    public Out(){

    }
    //成员内部类
    public class Inner{
        public Inner(){
            System.out.println(a);//成员内部类能直接访问外部类的属性
            System.out.println(b);
        }
    }
    //静态内部类
    public static  class StaticInner{
        public StaticInner(){
            Out out=new Out();
            int e=out.a;
//            System.out.println(a);//静态内部类不能直接访问外部类的属性
            System.out.println(b);
        }
    }
}
public class InnerClassTest{
    public  static  void main(String[] args){}
    Out out =new Out();
    //静态内部类不能直接用成员内部类的方法获取静态内部类
//    Out.Inner inner2=out.new Inner();
    Out.Inner inner3=out.new Inner();//成员内部类
    Out.StaticInner inner1=new Out.StaticInner();//静态内部类
}