/**
 * Java的常量池是方法区的一部分
 * 常量池分类
 * 常量池大体可以分为：静态常量池，运行时常量池。
 *
 * 静态常量池 存在于class文件中，比如经常使用的javap -verbose中，常量池总是在最前面把？
 *
 * 运行时常量池呢，就是在class文件被加载进了内存之后，常量池保存在了方法区中，通常说的常量池值的是运行时常量池。
 * 所以呢，讨论的都是运行时常量池
 *
 */
public class MethodArea {
    public static void main(String[] args){
        String s1="abc";
        String s2="abc";
        String s3="ab"+"c";
        String s4="ab"+new String("c");
        String s5=new String("abc");
        String s6=s5.intern();
        String s7="a";
        String s8="bc";
        String s9=s8+s7;
        System.out.println("s1==s2:"+(s1==s2));
        System.out.println("s1==s3:"+(s1==s3));
        System.out.println("s1==s4:"+(s1==s4));
        System.out.println("s1==s9:"+(s1==s9));
        System.out.println("s4==s5:"+(s4==s5));
        System.out.println("s1==s6:"+(s1==s6));
        /**
         * 1、s1 = = s2 很容易可以判断出来。s1 和 s2 都指向了方法区常量池中的Hello。
         * 2、s1 = = s3 这里要注意一下，因为做+号的时候，会进行优化，自动生成Hello赋值给s3，所以也是true
         * 3、s1 = = s4 s4是分别用了常量池中的字符串和存放对象的堆中的字符串，做+的时候会进行动态调用，最后生成的仍然是一个String对象存放在堆中。
         * 4、s1 = = s9 在JAVA9中，因为用的是动态调用，所以返回的是一个新的String对象。所以s9和s4，s5这三者都不是指向同一块内存
         * 5、s1 = = s6 为啥s1 和 s6地址相等呢？ 归功于intern方法，
         * 这个方法首先在常量池中查找是否存在一份equal相等的字符串如果有的话就返回该字符串的引用，
         * 没有的话就将它加入到字符串常量池中，所以存在于class中的常量池并非固定不变的，可以用intern方法加入新的
         *
         *
         */

    }
}
