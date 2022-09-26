package guru.springframework.sfgdi.config;


import com.springframework.pets.services.PetService;
import com.springframework.pets.services.PetServiceFactory;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

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
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return  new PropertyInjectedGreetingService();
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean(name="i18nService")
    @Profile({"ES","default"})
    I18NSpanishService i18NSpanishService(){
        return  new I18NSpanishService();
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return  new EnglishGreetingRepositoryImpl();
    }
    @Bean
    @Profile({"EN"}) // dependency injection in java configuration class
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return  new I18nEnglishGreetingService(englishGreetingRepository);
    }
    @Bean
    PetServiceFactory petServiceFactory(){
        return  new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }
    @Profile({"cat"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

}
