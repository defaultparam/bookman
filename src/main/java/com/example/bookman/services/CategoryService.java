package com.example.bookman.services;

import java.util.ArrayList;

import com.example.bookman.models.Topic;
import com.example.bookman.models.TopicCategory;
import com.example.bookman.utils.JsonConverter;

public class CategoryService {
	private final IOService ioSrv;
	
	public CategoryService(IOService ioSrv) {
		this.ioSrv = ioSrv;
	}
	
	public String listByCategory(TopicCategory categoryRequested) {
		var categoryTopics = new ArrayList<Topic>();
		var topics = ioSrv.loadFromFile();
		for (var topic : topics) {
			if (topic.getTopicCategory() == categoryRequested) {
				categoryTopics.add(topic);
			}
		}
		
		return JsonConverter.Serialize(categoryTopics);
	}
	
	public boolean addTopicToCategory(String title, TopicCategory category, String notes) {
		var topics = ioSrv.loadFromFile();
		
		Topic newTopic = new Topic(title, notes, category);
		
		topics.add(newTopic);
		
		ioSrv.saveToFile(topics);
		
		return true;
	}
}
