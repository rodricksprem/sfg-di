package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controller.ConstructorInjectedController;
import guru.springframework.sfgdi.controller.MyController;
import guru.springframework.sfgdi.controller.PropertyInjectedController;
import guru.springframework.sfgdi.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SfgDiApplication {

	/*
	Parameter 0 of constructor in guru.springframework.sfgdi.controller.ConstructorInjectedController required a single bean, but 4 were found:
	- constructorInjectedGreetingService: defined in file [D:\studyguides\Spring\spring5guruprojects\branches_sfg_di\master\sfg-di\target\classes\guru\springframework\sfgdi\services\ConstructorInjectedGreetingService.class]
	- greetingServiceImpl: defined in file [D:\studyguides\Spring\spring5guruprojects\branches_sfg_di\master\sfg-di\target\classes\guru\springframework\sfgdi\services\GreetingServiceImpl.class]
	- propertyInjectedGreetingService: defined in file [D:\studyguides\Spring\spring5guruprojects\branches_sfg_di\master\sfg-di\target\classes\guru\springframework\sfgdi\services\PropertyInjectedGreetingService.class]
	- setterInjectedGreetingService: defined in file [D:\studyguides\Spring\spring5guruprojects\branches_sfg_di\master\sfg-di\target\classes\guru\springframework\sfgdi\services\SetterInjectedGreetingService.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

	 */
	public static void main(String[] args) {
	ApplicationContext ctx= SpringApplication.run(SfgDiApplication.class, args);
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
