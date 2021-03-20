import java.util.ArrayList;
import java.util.List;

public class BasicObjectType {
    public static void main(String[] args) throws CloneNotSupportedException{
//        如下，byte类型数据，值的范围[-128,127]
//        为什么最大为127，由于二进制原因01111111，因为第一位为正负位，0为正，1为负
//        对127的二进制取反+1就是10000000，第一位为1，负数，这个就表示是-128
        byte a = 127;
        a+=1;
        System.out.println(a);
        List list=new ArrayList<>();
        list.add("asd");
        list.add("sssss");
        list.add("aaaaa");
        System.out.println(list);
        list.add(0,"hhh");
        System.out.println(list);
        //浅拷贝深拷贝
        Person p = new Person(23, "zhang");
        Person p1 = p;
        System.out.println(p);
        System.out.println("引用拷贝 赋值："+p1);
        Person p2=new Person(1,"ss");
        Person p3= (Person) p2.clone();
        System.out.println("新对象："+p2);
        System.out.println("clone对象："+p3);
        System.out.println("pName："+p2.getName().hashCode());
        System.out.println("p1Name："+p3.getName().hashCode());

    }
    public static class Person implements Cloneable{

            //private Integer age;
            private int age;//阿里规范中规定pojo类中的属性强制使用包装类型，这里只是测试

            private String name;

            public Person(Integer age, String name) {
                super();
                this.age = age;
                this.name = name;
            }

            public Integer getAge() {
                return age;
            }

            public void setAge(Integer age) {
                this.age = age;
            }

            public String getName()
            {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }

}
