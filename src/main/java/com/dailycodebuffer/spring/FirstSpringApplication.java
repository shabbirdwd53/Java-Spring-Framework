package com.dailycodebuffer.spring;

import com.dailycodebuffer.spring.model.Employee;
import com.dailycodebuffer.spring.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FirstSpringApplication {
    public static void main(String[] args) {
        var annotationContext = new AnnotationConfigApplicationContext(SpringBeanConfiguration.class);
        //By method name example
        System.out.println(annotationContext.getBean("firstName"));
        System.out.println(annotationContext.getBean("employeeNumber"));
        // defined custom name
        System.out.println(annotationContext.getBean("employeeObj"));
        //by type example --- This also now throws exception so we need to define bean name rather type or Primary
        // notice that it used primary bean in this get bean
        System.out.println(annotationContext.getBean(Organization.class));
        try {
            System.out.println(annotationContext.getBean("employee")); // bean not found example
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(annotationContext.getBean("employeeWithByTypeAndName"));
        System.out.println(annotationContext.getBean("employeeWithoutDefiningQualifier"));
    }
}
