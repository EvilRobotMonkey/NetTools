package SingDemo;

public class Singleton {

	private static Singleton instance;

	private Singleton() {};

//	public static Singleton getInstance() {
//		if (instance == null) {
//			instance = new Singleton();
//		}
//		return instance;
//	}
	
	//線程安全
//	public static synchronized Singleton getInstance(){
//		if(instance==null)
//			instance=new Singleton();
//		return instance;
//	}
	
	//双重校验锁
//	public static Singleton getSingleton(){
//		synchronized (Singleton.class) {
//		if(instance==null)
//				instance=new Singleton();
//			}
//		return instance;
//	}
	// 饿汉
//	private static Singleton instance_ =new Singleton();
//	
//	public static Singleton getInstance(){
//		return instance;
//	}
	
//	private Singleton instance_=null;
//	static {
//		instance=new Singleton();
//	}
//	public static Singleton getInstance(){
//		return instance_;
//	}
	
	//静态内部类  
	private static class SingletonHolder{
		private static final Singleton INSTANCE=new Singleton();
	}
	public static final Singleton getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
	
	public enum Singleton_{
		INSTANCE;
		public void whateverMethod(){};
	}
	
	/**
	 * 总结
·		有两个问题需要注意：
     1、如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类  装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。
     2、如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。

对第一个问题修复的办法是：
 1 private static Class getClass(String classname)      
 2                                          throws ClassNotFoundException {     
 3       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();     
 4       
 5       if(classLoader == null)     
 6          classLoader = Singleton.class.getClassLoader();     
 7       
 8       return (classLoader.loadClass(classname));     
 9    }     
10 }  
11 
 
 对第二个问题修复的办法是： 

 1 public class Singleton implements java.io.Serializable {     
 2    public static Singleton INSTANCE = new Singleton();     
 3       
 4    protected Singleton() {     
 5         
 6    }     
 7    private Object readResolve() {     
 8             return INSTANCE;     
 9       }    
10 }   
11 
对我来说，我比较喜欢第三种和第五种方式，简单易懂，而且在JVM层实现了线程安全（如果不是多个类加载器环境），一般的情况下，我会使用第三种方式，只有在要明确实现lazy loading效果时才会使用第五种方式，另外，如果涉及到反序列化创建对象时我会试着使用枚举的方式来实现单例，不过，我一直会保证我的程序是线程安全的，而且我永远不会使用第一种和第二种方式，如果有其他特殊的需求，我可能会使用第七种方式，毕竟，JDK1.5已经没有双重检查锁定的问题了。
========================================================================
 superheizai同学总结的很到位：
 
不过一般来说，第一种不算单例，第四种和第三种就是一种，如果算的话，第五种也可以分开写了。所以说，一般单例都是五种写法。懒汉，恶汉，双重校验锁，枚举和静态内部类。
我很高兴有这样的读者，一起共勉。
	 */
}
