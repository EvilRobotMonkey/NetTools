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
	
	//���̰�ȫ
//	public static synchronized Singleton getInstance(){
//		if(instance==null)
//			instance=new Singleton();
//		return instance;
//	}
	
	//˫��У����
//	public static Singleton getSingleton(){
//		synchronized (Singleton.class) {
//		if(instance==null)
//				instance=new Singleton();
//			}
//		return instance;
//	}
	// ����
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
	
	//��̬�ڲ���  
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
	 * �ܽ�
��		������������Ҫע�⣺
     1����������ɲ�ͬ����װ����װ�룬�Ǳ��п��ܴ��ڶ���������ʵ�����ٶ�����Զ�˴�ȡ������һЩservlet������ÿ��servletʹ����ȫ��ͬ����  װ�����������Ļ����������servlet����һ�������࣬���ǾͶ����и��Ե�ʵ����
     2�����Singletonʵ����java.io.Serializable�ӿڣ���ô������ʵ���Ϳ��ܱ����л��͸�ԭ��������������������л�һ��������Ķ��󣬽�������ԭ����Ǹ���������ͻ��ж���������ʵ����

�Ե�һ�������޸��İ취�ǣ�
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
 
 �Եڶ��������޸��İ취�ǣ� 

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
������˵���ұȽ�ϲ�������ֺ͵����ַ�ʽ�����׶���������JVM��ʵ�����̰߳�ȫ��������Ƕ�����������������һ�������£��һ�ʹ�õ����ַ�ʽ��ֻ����Ҫ��ȷʵ��lazy loadingЧ��ʱ�Ż�ʹ�õ����ַ�ʽ�����⣬����漰�������л���������ʱ�һ�����ʹ��ö�ٵķ�ʽ��ʵ�ֵ�������������һֱ�ᱣ֤�ҵĳ������̰߳�ȫ�ģ���������Զ����ʹ�õ�һ�ֺ͵ڶ��ַ�ʽ���������������������ҿ��ܻ�ʹ�õ����ַ�ʽ���Ͼ���JDK1.5�Ѿ�û��˫�ؼ�������������ˡ�
========================================================================
 superheizaiͬѧ�ܽ�ĺܵ�λ��
 
����һ����˵����һ�ֲ��㵥���������ֺ͵����־���һ�֣������Ļ���������Ҳ���Էֿ�д�ˡ�����˵��һ�㵥����������д�����������񺺣�˫��У������ö�ٺ;�̬�ڲ��ࡣ
�Һܸ����������Ķ��ߣ�һ���㡣
	 */
}
