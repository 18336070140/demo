package zj4_6;

		 import java.lang.reflect.InvocationTargetException;
  import java.lang.reflect.Method;

		  public class InvokeMethod1 {


		      public static void main(String[] args) throws Exception {
				  Student stu1 = new Student();//这一new 产生一个Student对象，一个Class对象。
				  Class stuClass = stu1.getClass();//获取Class对象
				  System.out.println(stuClass.getName());

				  //第二种方式获取Class对象
				  Class stuClass2 = Student.class;
				  System.out.println(stuClass == stuClass2);


//		         try {
//			            Class student=Class.forName("zj4_6.Student");//动态加载类，获取当前类的Class对象
//			            //获取Student类名称为printinfo地方法
//			            Method methods1=student.getMethod("printInfo");
//			            //调用frintInfo方法
//			             methods1.invoke(student.newInstance()); //通过实例化的对象，调用无参数的方法
//			            //获取类中名称为printInfo地方法，String，class是参数类型
//			             Method methods2=student.getMethod("printAddress", String.class);//注意参数不是String
//			             //调用printAddress方法，其中HK是方法传入的参数值
//			            methods2.invoke(student.newInstance(),"HK");//通过对象，调用有参数的方法
//			} catch (ClassNotFoundException e) {   e.printStackTrace();  }

		      }
		  }