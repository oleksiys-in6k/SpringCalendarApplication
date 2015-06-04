package com.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        CalendarApplication calendarApplication = (CalendarApplication) beanFactory.getBean("CalendarApplication");
        calendarApplication.execute();

    }

}
