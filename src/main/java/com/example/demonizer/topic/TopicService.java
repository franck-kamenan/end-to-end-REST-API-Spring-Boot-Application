package com.example.demonizer.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {

        // return all topics
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                        .forEach(topics::add);
        return topics;
    }

    // Filter by id and take the first id that match
    public Optional<Topic> getTopic(String id) {

        return topicRepository.findById(id);
    }

    // Adding a topic
    public void addTopic(Topic topic) {

        topicRepository.save(topic);
    }

    // Updating a topic
    public void updateTopic(String id, Topic topic) {

        topicRepository.save(topic);
    }

    // Deleting a topic
    public void deleteTopic(String id) {

        topicRepository.deleteById(id);
    }
}

