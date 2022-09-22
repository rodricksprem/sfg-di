package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SfgDiApplication {

	/*

org.springframework.beans.factory.BeanDefinitionStoreException: Failed to parse configuration class [guru.springframework.sfgdi.SfgDiApplication]; nested exception is org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'i18nService' for bean class [guru.springframework.sfgdi.services.I18nEnglishGreetingService] conflicts with existing, non-compatible bean definition of same name and class [guru.springframework.sfgdi.services.I18NSpanishService]
	at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:189) ~[spring-context-5.3.22.jar:5.3.22]

	 */
	public static void main(String[] args) {
	ApplicationContext ctx= SpringApplication.run(SfgDiApplication.class, args);
		I18nController i18nController =(I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
	MyController myController =(MyController) ctx.getBean("myController");
	System.out.println(myController.sayHello());
		System.out.println("------ Property");
	PropertyInjectedController propertyInjectedController =(PropertyInjectedController) ctx.getBean("propertyInjectedController");
	System.out.println(propertyInjectedController.getGreeting());
		System.out.println("------ Setter");
	SetterInjectedController setterInjectedController =(SetterInjectedController) ctx.getBean("setterInjectedController");
	System.out.println(setterInjectedController.getGreeting());
		System.out.println("------ Constructor");
	ConstructorInjectedController constructorInjectedController =(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
	System.out.println(constructorInjectedController.getGreeting());

	}

}
