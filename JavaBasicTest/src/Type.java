/**
 * Java中有 8 种基本数据类型，分别为：
 *
 * 6 种数字类型 ：byte、short、int、long、float、double
 * 1 种字符类型：char
 * 1 种布尔型：boolean。
 * 基本数据类型不是对象
 * 这八种基本类型都有对应的包装类分别为：Byte、Short、Integer、Long、Float、Double、Character、Boolean
 基本类型	位数	字节	默认值
 int	    32	    4	    0
 short	    16	    2	    0
 long	    64	    8	    0L
 byte	    8	    1	    0
 char	    16	    2	    'u0000'
 float	    32	    4	    0f
 double	    64	    8	    0d
 boolean	1		        false
 *  对于 boolean，官方文档未明确定义，它依赖于 JVM 厂商的具体实现。逻辑上理解是占用 1 位，但是实际中会考虑计算机高效存储因素。
 *  注意：
 *      Java 里使用 long 类型的数据一定要在数值后面加上 L，否则将作为整型解析
 *
 *
 */
public class Type {
    public static void main(String[] args){
        /**
         * 装箱就是**自动将基本数据类型转换为包装器类型**；
         * 拆箱就是**自动将包装器类型转换为基本数据类型**。
         * Java 基本类型的包装类的大部分都实现了常量池技术，
         * 即 Byte,Short,Integer,Long,Character,Boolean；前面 4 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据，
         * Character 创建了数值在[0,127]范围的缓存数据，Boolean直接返回 True Or False。
         * 未超出范围直接从缓存中取
         * 如果超出对应范围仍然会去创建新的对象
         */
        ZX();
    }
    public static void ZX(){
        Integer i=5;//装箱，自动调用Integer的valueOf(int) 的方法
        int n=5;//拆箱，自动调用Integer的intvalueOf()方法

        int i0=5;
        int ii=5;
        Integer i1=5;
        Integer i2=new Integer(5);
        Integer i6=5;
        Integer i3=130;//编译时被翻译成：Integer i4 = Integer.valueOf(130);
        Integer i4=130;
        Integer i5=5;
        Long l1=135L;
        Long l2=130L;

        System.out.println("i0==i1"+(i0==ii));//基本类型==直接比较的是自己的值
        System.out.println("i0==i1"+(i0==i1));//Integer包装类无法直接比较，触发自动拆箱
        System.out.println("i1==i2"+(i1==i2));//False，新建了对象，所以为false
        System.out.println("i1==i6"+(i1==i6));//true，没超出范围，直接在常量池寻找
        System.out.println("i3==i4"+(i3==i4));//超出范围，创建了新的对象
        System.out.println("i3==i4"+(i1==i5));//True，没有超出范围，直接取缓存
        System.out.println("l1.equals(i1+i3)"+(l1.equals(i1+i3)));//false，数据类型不同
        System.out.println("l1==(i1+i3)"+(l1==(i1+i3)));//==运算触发向上转型，int转long
        System.out.println("l1.equals(i1 + l2) : " + l1.equals(i1 + l2));//true,+号运算触发int向上转型成long

    }
    /**
     * 向上转型 : 通过子类对象(小范围)实例化父类对象(大范围),这种属于自动转换
     * 向下转型 : 通过父类对象(大范围)实例化子类对象(小范围),这种属于强制转换
     */
    public static void zx(){
        int i=2;
        long l=i;//long范围比int大，自动向上转型
        int j= (int) l;//int 比long小，手动向下转型
    }
}
