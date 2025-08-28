package com.example.bookman.models;

import java.util.UUID;

public class Topic {
	UUID id;
	String title;
	String notes;
	TopicCategory category;

	public Topic(String title) {
		this(title, "", TopicCategory.UNDEFINED);
	}
	
	public Topic(String title, String notes) {
		this(title, notes, TopicCategory.UNDEFINED);
	}

	public Topic(String title, TopicCategory category) {
		this(title, "", category);
	}
	public Topic(String title, String notes, TopicCategory category) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.notes = notes;
		this.category = category;
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
		return category;
	}
}