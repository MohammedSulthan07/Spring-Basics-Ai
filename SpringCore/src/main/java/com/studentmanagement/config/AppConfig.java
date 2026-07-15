package com.studentmanagement.config;


import com.studentmanagement.model.Address;
import com.studentmanagement.model.Course;
import com.studentmanagement.model.Department;
import com.studentmanagement.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.studentmanagement")
@PropertySource({"classpath:hibernate.properties"})
public class AppConfig {

    @Autowired
    private Environment env;
    @Value("${hibernate.connection.url}")
    private String url;

    @Value("${hibernate.connection.username}")
    private String username;

    @Value("${hibernate.connection.password}")
    private String password;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    @Value("${hibernate.show_sql}")
    private String show_Sql;

    @Bean
    public SessionFactory sessionFactory(){
      Configuration configuration = new Configuration();
      configuration.setProperty("hibernate.connection.url",url);
        configuration.setProperty("hibernate.connection.username",username);
        configuration.setProperty("hibernate.connection.password",password);
        configuration.setProperty("hibernate.hbm2ddl.auto",hbm2ddlAuto);
        configuration.setProperty("hibernate.show_sql",show_Sql);

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Address.class);

        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
