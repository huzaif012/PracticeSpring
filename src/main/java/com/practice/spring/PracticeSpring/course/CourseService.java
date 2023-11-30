package com.practice.spring.PracticeSpring.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Spring creates the instance of the service while initializing itself so we can use it in the program
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
//    private List<Course> topics = new ArrayList<>(Arrays.asList( //only array.AsList will create only non mutable array so we needed to add ArrayList<>
//                new Course("spring", "Spring Framework", "SpringFrameworkDiscription"),
//                new Course("java", "coreJava","All the core Java")
//        ));

    public List<Course> getAllCourses(String topicId){

        //return topics;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);
    }

    public void addCourse(Course course){
        //topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for(int i = 0; i<topics.size();i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
         courseRepository.save(course);
        }


    public void deleteCourse(String id) {
    //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
