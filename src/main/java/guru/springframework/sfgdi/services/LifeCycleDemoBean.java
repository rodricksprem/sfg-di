package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean,ApplicationContextAware, BeanNameAware, BeanFactoryAware {
    public LifeCycleDemoBean(){
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## I'm in the LifeCycleBean setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## I'm in the LifeCycleBean setBeanName "+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## I'm in the LifeCycleBean afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## I'm in the LifeCycleBean setApplicationContext");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## I'm in the LifeCycleBean destroy");
    }

    public void beforeInit() {
        System.out.println("## I'm in the LifeCycleBean beforeInit");
    }

    public void afterInit() {
        System.out.println("## I'm in the LifeCycleBean afterInit");
    }

    @PostConstruct

    public void postConstructMethod() {
        System.out.println("## I'm in the LifeCycleBean PostConstruct method");
    }

    @PreDestroy
    public void preDestroyMethod() {
        System.out.println("## I'm in the LifeCycleBean PreDestroy method");
    }

}
