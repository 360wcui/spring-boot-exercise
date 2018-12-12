package com.example.springexplorationsjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "spring framework", "spring framework description"),
            new Topic("java", "java", "java description"),
            new Topic("javascript", "javascript", "javascript description")
            ));

    private boolean isNative = false;

    public List<Topic> getAllTopics() {
        if (isNative)
            return topics;
        else {
            List<Topic> topics = new ArrayList<>();
            topicRepository.findAll().forEach(topics::add);

            return topics;
        }
    }

    public Topic getTopic(String id) {
        if (isNative)
            return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        else
            return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
        if (isNative) {
            topics.add(topic);
        } else {
           topicRepository.save(topic);
        }
    }

    public void updateTopic(String id, Topic topic) {
        if (isNative) {
            for (int i = 0; i < topics.size(); i++) {
                if (topics.get(i).getId().equals(id)) {
                    System.out.println("gets here");
                    topics.set(i, topic);
                    return;
                }
            }
        } else {
            topicRepository.save(topic);
        }
    }

    public void deleteTopic(String id) {
        if (isNative) {
            topics.removeIf(t->t.getId().equals(id));
        } else {
            topicRepository.deleteById(id);
        }
    }

}
