
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observers.Observers;


public class RxjavaDemo1 {
	private static ArrayList<Student>list =new ArrayList<>();
	public static void init()
	{
//		// 行为 
		Observer<String>objserver=new Observer<String>(){

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println("Item:success");
				
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(String arg0) {
				// TODO Auto-generated method stub
				System.out.println("Item: "+arg0);
			}
			
		};
//		 动机
		Observable.create(new Observable.OnSubscribe<String>() {

			@Override
			public void call(Subscriber<? super String> arg0) {
				// TODO Auto-generated method stub
				arg0.onNext("hello");
				arg0.onNext("Hi");
				arg0.onNext("Aloha");
				arg0.onCompleted();
			}}).subscribe(objserver);
		
		Observable.just("wang", "tao", "tao").subscribe(objserver);
		
		list.add(new Student("a","wang","tao"));
		list.add(new Student("b","wang","tao"));
		list.add(new Student("c","wang","tao"));
		list.add(new Student("d","wang","tao"));
		Observable.from(list).subscribe(new Action1<Student>() {

			@Override
			public void call(Student arg0) {
				// TODO Auto-generated method stub
				System.out.println("item："+arg0.toString());
			}
		},new Action1<Throwable>() {

			@Override
			public void call(Throwable arg0) {
				// TODO Auto-generated method stub
				arg0.printStackTrace();
			}
		},new Action0() {
			
			@Override
			public void call() {
				// TODO Auto-generated method stub
				System.out.println("success");
			
			}
		});
		
		
		
//		Observable.just("str1", "str2","str3").flatMap(new Func1<String, Observable<Student>>() {
//
//			@Override
//			public Observable<Student> call(String arg0) {
//				// TODO Auto-generated method stub
//				
//				
//				
//				return new Observable<RxjavaDemo1.Student>;
//			}
//		});
		
	}
	 public static class Student{
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
