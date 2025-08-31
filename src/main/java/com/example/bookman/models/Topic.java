package com.example.bookman.models;

import java.util.UUID;

public class Topic {
	UUID id;
	String title;
	String notes;
	TopicCategory topicCategory;

	/*
	 * ONLY TO BE USED FOR IMPORTING JSON FILES FOR JACKSON
	 */
	public Topic() {}
	public Topic(String title) {
		this(title, "", TopicCategory.UNDEFINED);
	}
	
	public Topic(String title, String notes) {
		this(title, notes, TopicCategory.UNDEFINED);
	}

	public Topic(String title, TopicCategory topicCategory) {
		this(title, "", topicCategory);
	}
	public Topic(String title, String notes, TopicCategory topicCategory) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.notes = notes;
		this.topicCategory = topicCategory;
	}
	
	public String getId() {
		return id.toString();
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public TopicCategory getTopicCategory() {
		return topicCategory;
	}
}