import java.util.HashMap;

public class HashmapTest {

    public static void main(String[] args) {
        User user1=new User(18,"张三");
        User user2=new User(18,"张三");
        System.out.println("user1.hashCode="+user1.hashCode());
        System.out.println("user2.hashCode="+user2.hashCode());
        System.out.println("user1.equals(user2)="+user1.equals(user2));
        HashMap hashMap=new HashMap();
        hashMap.containsKey(args);
        hashMap.hashCode();

    }
}
class User{
    private int age;
    private String name;
    public User(final int age,final String name){}
    public int getAge(){return this.age;}
    public void setAge(final int age){this.age=age;}
    public String getName(){return  this.name;}
    public void setName(final String name){this.name=name;}


//    @Override
//    public  boolean equals(final Object o){
//        if (this==o){return  true;}
//        if(o==null || this.getClass()!=o.getClass()){return false;}
//        final User user=(User) o;
//        return this.age==user.age && this.name.equals(user.name);
//    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(this.age,this.name);
//    }
}

//实际输出结果：null