package com.practice.spring.PracticeSpring.course;

import com.practice.spring.PracticeSpring.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class CourseController {
    @Autowired //marks it as it needs dependency injection
    private CourseService CourseService; //instance of the @service


    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return CourseService.getAllCourses(id);
    }

    //this return only one topic
    @RequestMapping("/topics/{topicId}/courses/courses/{courseId}") //{} curly braces shows that inside it is variable
    public Optional<Course> getCourse(@PathVariable String id){ //@Pathvariable tells spring that the id is we need to get from mapping path
        //spring MVC should know there is @PathVariable that is why we give this annotation
    return CourseService.getCourse(id);
    }

    //for POST or add new topic
    @RequestMapping(method = POST, value="/topics/{topicId}/courses/{id}")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){// @Request body will tell spring mvc that topic will contain the json opject to add in the list
        course.setTopic(new Topic(topicId, "", ""));
        CourseService.addCourse(course);
    }

    @RequestMapping(method = PUT, value ="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        CourseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
         CourseService.deleteCourse(id);
    }
}
//whatever return type we have with mapped class it will automatically will get converted to json object and return to the mapped url it is done by springMVC.
//how to create a RestApi with spring boot
/* We create a class with annotation of @RestController
 then we build a method with business logic which return the
 whatever it needs to, and we annotate that method with @RequestMapping(/url)
 what ever is returned spring MVC convert it into json object and get it availble with
 required url*/