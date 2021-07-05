package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class MainTest {

	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//		Object o =applicationContext.getBean("person");

		ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("ioc容器创建完成");
				String[]  name = annotationConfigApplicationContext.getBeanDefinitionNames();
		for ( String s:name) {
			System.out.println(s);

		}
////		Person p = (Person) annotationConfigApplicationContext.getBean("person");
//		Environment e = annotationConfigApplicationContext.getEnvironment();
//		String nickName = e.getProperty("person.nickName");
//		System.out.println(nickName);

		((AnnotationConfigApplicationContext) annotationConfigApplicationContext).close();
//		annotationConfigApplicationContext.getBean("beanName");

	}
}
