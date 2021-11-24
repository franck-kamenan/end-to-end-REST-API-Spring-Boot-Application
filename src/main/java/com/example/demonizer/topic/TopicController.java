package com.example.demonizer.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    
    @Autowired
    private TopicService topicService;
    
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {

        return topicService.getAllTopics();
    }

    // Getting a single resource
    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {

        return topicService.getTopic(id);
    }

    // Creating a new resource with POST
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {

        topicService.addTopic(topic);
    }

    // Implementing Update with PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {

        topicService.updateTopic(id, topic);
    }

    // Implementing Delete with DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {

        topicService.deleteTopic(id);
    }
}

