package com.practice.spring.PracticeSpring.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class TopicController {
    @Autowired //marks it as it needs dependency injection
    private TopicService topicService; //instance of the @service


    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAlltopics();
    }

    //this return only one topic
    @RequestMapping("/topics/{id}") //{} curly braces shows that inside it is variable
    public Optional<Topic> getTopic(@PathVariable String id){ //@Pathvariable tells spring that the id is we need to get from mapping path
        //spring MVC should know there is @PathVariable that is why we give this annotation
    return topicService.getTopic(id);
    }

    //for POST or add new topic
    @RequestMapping(method = POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){// @Request body will tell spring mvc that topic will contain the json opject to add in the list
        topicService.addTopic(topic);
    }

    @RequestMapping(method = PUT, value ="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
         topicService.deleteTopic(id);
    }
}
//whatever return type we have with mapped class it will automatically will get converted to json object and return to the mapped url it is done by springMVC.
//how to create a RestApi with spring boot
/* We create a class with annotation of @RestController
 then we build a method with business logic which return the
 whatever it needs to, and we annotate that method with @RequestMapping(/url)
 what ever is returned spring MVC convert it into json object and get it availble with
 required url*/