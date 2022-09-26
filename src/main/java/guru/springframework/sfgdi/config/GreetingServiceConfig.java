package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// using @Configuration and @Bean to avoid component scanning for various stereotype

@Configuration
public class GreetingServiceConfig {

    @Bean(name = "constructorInjectedGreetingService")
    ConstructorInjectedGreetingService getConstructorGreetingService(){
        return  new ConstructorInjectedGreetingService();
    }
   /* @Bean(name = "setterInjectedGreetingService")
    SetterInjectedGreetingService getSetterGreetingService(){
        return  new SetterInjectedGreetingService();
    }*/
    @Bean(name = "propertyInjectedGreetingService")
    PropertyInjectedGreetingService getPropertyGreetingService(){
        return  new PropertyInjectedGreetingService();
    }
}
