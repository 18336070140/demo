package com.atguigu.condition;

import com.atguigu.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("#######################ImportBeanDefinitionRegistrar.registerBeanDefinitions");
		RootBeanDefinition beanDefinitionRegistry = new RootBeanDefinition(RainBow.class);
		registry.registerBeanDefinition("rainBow",beanDefinitionRegistry);
	}
}
