package com.practice.spring.PracticeSpring.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
//CrudRepository<Topic, String> first argument is Entity name and second arg is datatype of id

    //getAllcourses()
    //getCourse(String id)
    //updateCourse(topic t)
    //deleteCourse(String id)
}
