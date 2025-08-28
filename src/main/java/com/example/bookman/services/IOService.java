package com.example.bookman.services;

import java.util.ArrayList;

import com.example.bookman.models.Topic;

public class IOService {

	public boolean saveToFile(ArrayList<Topic> topicsList) {
		// TODO: Implementation: saveToFile()
		return true;
	}
	
	public ArrayList<Topic> loadFromFile() {
		// XXX: Use app.props to change the name of the file it saves things to
		// TODO: Implementation: loadFromFile()

		return new ArrayList<Topic>();
	}
	
	public boolean exportToCsv() {
		// TODO: Implementation: exportToCsv()
		return true;
	}
	
	public boolean exportToXml() {
		// TODO: Implementation: exportToCsv()
		return true;
		
	}
	
}