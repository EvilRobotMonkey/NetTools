import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;


public class RxjavaDemo {
	public static void DemoInit()
	{

    	//Rxjava ¾ÙÀý
    	List<Student> list_0 = new ArrayList<>();  
    	List<Student> list_1 = new ArrayList<>();  
    	list_0.add(new Student("Merge-A11", "20", "1101"));  
    	list_0.add(new Student("Merge-A12", "23", "1102"));  
    	list_0.add(new Student("Merge-A13", "22", "1103"));  
    	list_0.add(new Student("Merge-A14", "21", "1104"));  
    	list_0.add(new Student("Merge-A15", "20", "1105"));  
    	  
    	list_1.add(new Student("Merge-B11", "20", "1101"));  
    	list_1.add(new Student("Merge-B12", "23", "1102"));  
    	list_1.add(new Student("Merge-B13", "22", "1103"));  
    	Observable<Student> obs_0 = Observable.from(list_0);  
    	Observable<Student> obs_1 = Observable.from(list_1);  
    	Observable<Student> obsMerge = Observable.merge(obs_0, obs_1);  
    	obsMerge.subscribe(new Observer<Student>() {  
    	            @Override  
    	            public void onCompleted() {  
    	  
    	            }  
    	  
    	            @Override  
    	            public void onError(Throwable e) {  
    	  
    	            }  
    	  
    	            @Override  
    	            public void onNext(Student student) {  
    	               System.out.println(student.toString());
    	            
    	            }  
    	        });  
	}
	static class Student{
    	private String str1;
    	private String str2;
    	private String str3;
    	public Student(String str1,String str2,String str3){
    		this.str1=str1;
    		this.str2=str2;
    		this.str3=str3;
    	
    	}
		public String getStr1() {
			return str1;
		}
		public void setStr1(String str1) {
			this.str1 = str1;
		}
		public String getStr2() {
			return str2;
		}
		public void setStr2(String str2) {
			this.str2 = str2;
		}
		public String getStr3() {
			return str3;
		}
		public void setStr3(String str3) {
			this.str3 = str3;
		}
		@Override
		public String toString() {
			return "Student [str1=" + str1 + ", str2=" + str2 + ", str3="
					+ str3 + "]";
		}
    	
    }

}
