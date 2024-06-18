package com.dailycodebuffer.spring;

import com.dailycodebuffer.spring.model.Employee;
import com.dailycodebuffer.spring.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Annotation tell spring that this is a configuration class.
@Configuration
public class SpringBeanConfiguration {
//define different beans here
    @Bean
    public String firstName() {
        return "dcb";
    }
    @Bean
    public int employeeNumber() {
        return 1;
    }
    // we can also define different java object as bean
    @Bean(name = "employeeObj")
    public Employee employee() {
        return new Employee("new", 2, organization()); // Wiring org object with employee object
    }

    @Bean
    public Employee employeeWithByTypeAndName(String firstName, int employeeNumber, @Qualifier("organization") Organization employeeOrg) {
        return new Employee(firstName, employeeNumber, employeeOrg); // Wiring by type and name , automatically detected which to wire
        // default it tries to wire by type then name
        // as we introduced one more Organization type bean , spring got confused which needs to be used.
        // To define this we need to specify qualifier on  name
    }

    @Bean
    public Organization organization() {
        return new Organization(100, "org1");
    }

    @Bean
    @Primary
    public Organization organization2() {
        return new Organization(200, "org2");
    }

    @Bean
    public Employee employeeWithoutDefiningQualifier(String firstName, int employeeNumber, Organization employeeOrg) {
        return new Employee(firstName, employeeNumber, employeeOrg); // It now uses primary bean
    }
}
