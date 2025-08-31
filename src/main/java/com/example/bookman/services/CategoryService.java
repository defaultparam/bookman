package com.example.bookman.services;

import java.util.ArrayList;

import com.example.bookman.config.FileType;
import com.example.bookman.models.Topic;
import com.example.bookman.models.TopicCategory;
import com.example.bookman.utils.JsonConverter;

public class CategoryService {

	public static String listByCategory(TopicCategory categoryRequested) {
		var categoryTopics = new ArrayList<Topic>();
		var topics = IOService.importFromFile("");
		for (var topic : topics) {
			if (topic.getTopicCategory() == categoryRequested) {
				categoryTopics.add(topic);
			}
		}

		return JsonConverter.Serialize(categoryTopics);
	}

	public static boolean addTopicToCategory(String title, TopicCategory category, String notes) {

		Topic newTopic = new Topic(title, notes, category);
		ArrayList<Topic> topics = new ArrayList<Topic>();
		topics.add(newTopic);

		IOService.exportToFile(topics, null, FileType.JSON);

		return true;
	}
}
