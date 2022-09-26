package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controller.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
/*
ComponentScan is required if the Spring streotype components are in different package altogether .
ex:com.springframework.pets.services
@ComponentScan(basePackages = {"guru.springframework.sfgdi","com.springframework.pets.services"})
As we have added javaconfiguration @Bean ,no need for componentscan
*/

@SpringBootApplication
@ComponentScan(basePackages = {"guru.springframework.sfgdi","com.springframework.pets"})
public class SfgDiApplication {

	/*

org.springframework.beans.factory.BeanDefinitionStoreException: Failed to parse configuration class [guru.springframework.sfgdi.SfgDiApplication]; nested exception is org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'i18nService' for bean class [guru.springframework.sfgdi.services.I18nEnglishGreetingService] conflicts with existing, non-compatible bean definition of same name and class [guru.springframework.sfgdi.services.I18NSpanishService]
	at org.springframework.context.annotation.ConfigurationClassParser.parse(ConfigurationClassParser.java:189) ~[spring-context-5.3.22.jar:5.3.22]

	 */
	public static void main(String[] args) {
	ApplicationContext ctx= SpringApplication.run(SfgDiApplication.class, args);
		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());
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

		System.out.println("------ Singleton Bean");
		SingletonBean singletonBean =ctx.getBean("singletonBean", SingletonBean.class);
		singletonBean.setValue(10);
		System.out.println(singletonBean.getValue());

		System.out.println("------ Singleton Bean");
		SingletonBean singletonBeanOne =ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBeanOne.getValue());


		System.out.println("------ Singleton Bean");
		SingletonBean singletonBeanTwo =ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBeanTwo.getValue());



		System.out.println("------ Prototype Bean");
		PrototypeBean prototypeBean =ctx.getBean("prototypeBean", PrototypeBean.class);
		prototypeBean.setValue(10);
		System.out.println(prototypeBean.getValue());

		System.out.println("------ Prototype Bean");
		PrototypeBean prototypeBeanNew =ctx.getBean("prototypeBean", PrototypeBean.class);
		prototypeBean.setValue(20);
		System.out.println(prototypeBeanNew.getValue());


		System.out.println("------ Prototype Bean");
		PrototypeBean prototypeBeanSecond =ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println(prototypeBeanSecond.getValue());

		System.out.println("------ Fake Data source ");
		FakeDataSource fakeDataSource = ctx.getBean("fakeDataSource",FakeDataSource.class);
		System.out.println(fakeDataSource.getUserName());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcURL());

	}

}
