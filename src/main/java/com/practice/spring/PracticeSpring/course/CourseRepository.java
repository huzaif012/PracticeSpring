package com.practice.spring.PracticeSpring.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
//CrudRepository<Topic, String> first argument is Entity name and second arg is datatype of id
    public List<Course> findByName(String name);//you don't have to implement the method must declare the method with the findByProperty name format, and Sprong Data JPA will implement the method for you
    public List<Course> findByTopicId(String topicId);//Make sure to write the method name in camel-case!
    //getAllcourses()
    //getCourse(String id)
    //updateCourse(topic t)
    //deleteCourse(String id)
}

/*
 Packaging and running a Spring Boot app
 we need to create a jar file first
 go to cmd go to the path of project run mvn clean install it will generate the
 Jar file
 we can run that jar file by java -jar JarName
 if we need the WAR file open Pom change the <packaging>jar<packaging> to <packaging>war<packaging> and again do
 mvn clean install it will generate WAR file

 Ops Actuator
 is a group of binaries that is added to class path
 if we go localhost:8080/health it will give the health of our applcation
 What we have learned in this course
 Starting a spring Boot app
 Spring Mvc
 Booting Spring Boot
 Spring Data JPA
 App Execution and Actuator

 */