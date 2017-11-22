package com.example.demo.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerTopic {

	@Autowired
	private TopicService topicservice;

	@RequestMapping("/")
	public String Home() {
		return "Welcome to Spring Boot Application with JPA";
	}

	@RequestMapping("/topics")
	public List<Topic> returnTopics() {
		return topicservice.getAllTopics();
	}

	@RequestMapping("/topics/{name}")
	public Topic getTopic(@PathVariable String name) {
		return topicservice.getTopic(name);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics", consumes = "application/json")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{name}", consumes = "application/json")
	public void addTopic(@RequestBody Topic topic, @PathVariable String name) {
		topicservice.updateTopic(name, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{delete_name}")
	public void deleteTopic(@PathVariable String delete_name) {
		topicservice.deleteTopic(delete_name);
	}

}
