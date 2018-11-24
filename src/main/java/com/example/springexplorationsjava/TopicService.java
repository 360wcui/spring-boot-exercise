package com.example.springexplorationsjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopicService {

    private TopicRepository topicRepository;

//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "spring framework", "spring framework description"),
//            new Topic("java", "java", "java description"),
//            new Topic("javascript", "javascript", "javascript description")
//            ));

    public List<Topic> getAllTopics() {
        //return topics;

        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
       // return topics.stream().filter(topic -> topic.getId() == id).findFirst().get();
    }

    public void addTopic(Topic topic) {
       // topics.add(topic);

        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i = 0; i < topics.size(); i++) {
//            if (topics.get(i).getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }

        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        topicRepository.deleteById(id);
    }

}
