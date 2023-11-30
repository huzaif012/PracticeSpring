package com.practice.spring.PracticeSpring.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Spring creates the instance of the service while initializing itself so we can use it in the program
@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    private List<Topic> topics = new ArrayList<>(Arrays.asList( //only array.AsList will create only non mutable array so we needed to add ArrayList<>
                new Topic("spring", "Spring Framework", "SpringFrameworkDiscription"),
                new Topic("java", "coreJava","All the core Java")
        ));

    public List<Topic> getAlltopics(){

        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for(int i = 0; i<topics.size();i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
         topicRepository.save(topic);
        }


    public void deleteTopic(String id) {
    //topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
