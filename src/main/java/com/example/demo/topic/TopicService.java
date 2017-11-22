package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicDataRepo topicdata;

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("Spring", "Java Framework"), new Topic("Angular", "Javascript Framework"),
					new Topic("Reactjs", "Javascript Framework"), new Topic("Ruby on rails", "Ruby Framework")));

	// Get all service
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicdata.findAll().forEach(topics::add);
		return topics;
	}

	// Get a specific one
	public Topic getTopic(String name) {
		return topicdata.findOne(name);
	}

	// Insert one
	public void addTopic(Topic data) {
		topicdata.save(data);
	}

	// Update data for existing
	public void updateTopic(String name, Topic data) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getName().equals(name)) {
				topics.set(i, data);
				return;
			}
		}
	}

	// Delete one
	public void deleteTopic(String data) {
		topics.removeIf(t -> t.getName().equals(data));
	}

}
