package com.example.bookman.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
	name = "topic",
	description = "View or Update topics here",
	mixinStandardHelpOptions = true
	)
public class TopicCommand implements Runnable {
	
	@Option(names = { "-t", "--title" }, description = "Specify the title to view or update", required = true)
	String title;

	@Override
	public void run() {
		System.out.println("Inside Topic Command!");
		// TODO Auto-generated method stub
		
	}
	
	
}
