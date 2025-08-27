package com.example.bookman.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "lifestyle", description = "Add or List topics related to life", subcommands = {
		AddCommand.class }, mixinStandardHelpOptions = true)
public class LifestyleCommand implements Runnable {

	@Option(names = { "-l", "--list" }, description = "Lists all the topics related to lifestyle category")
	boolean viewLifestyleTopics;

	@Override
	public void run() {
		if (viewLifestyleTopics) {
			// TODO: Create a new service layer to manage all this!
		}
	}

}
