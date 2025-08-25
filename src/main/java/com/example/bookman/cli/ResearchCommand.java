package com.example.bookman.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "research", description = "Add or List topics related to work", subcommands = {
		AddCommand.class }, mixinStandardHelpOptions = true)
public class ResearchCommand implements Runnable {

	@Option(names = { "-l", "--list" }, description = "Lists all the topics related to research category")
	boolean viewResearchTopics;

	@Override
	public void run() {
		if (viewResearchTopics) {
			// TODO: Create a new service layer to manage all this!
		}
	}

}
