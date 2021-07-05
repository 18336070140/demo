package com.atguigu.config;

import com.atguigu.bean.*;
import com.atguigu.condition.MyConditional;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MySelecter;
import com.atguigu.service.ColorService;
import org.springframework.context.annotation.*;

@PropertySource(value = {"classpath:/person.properties"})
@Configuration
@ComponentScan(value = {"com.atguigu"})
//@ComponentScan(value = "com.atguigu",excludeFilters = {
//		@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//})
//@Import({Color.class, Red.class, MySelecter.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {

//	@Conditional(MyConditional.class)
//	@Scope("prototype")
//	@Bean("beanName")
//	public Person person(){
//		System.out.println("******************make   person************");
//		return new Person();
//	}

//	@Scope("prototype")
//	@Bean(initMethod = "init",destroyMethod = "detory")
//	public Car car(){
//		System.out.println("########################@Bean car");
//		return new Car();
//	}
//
//
//	@Scope("prototype")
//	@Bean
//	public Cat cat(){
//		System.out.println("#######################@Bean cat");
//		return new Cat();
//	}

//	@Scope("prototype")
//	@Bean
//	public Dog dog(){
//		System.out.println("#######################@Bean dog");
//		return new Dog();
//	}
//
//
//	@Bean
//	public MyBeanPostProcessor myBeanPostProcessor(){
//		System.out.println("#######################@Bean dog");
//		return new MyBeanPostProcessor();
//	}
    @Primary
	@Bean
	public ColorService service(){
		System.out.println("!!!!!!!!!!!!!!!!!!");
		return new ColorService();
	}
}
