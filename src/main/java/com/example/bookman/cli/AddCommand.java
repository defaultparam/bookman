package com.example.bookman.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "add", description = "Add a topic to the category", mixinStandardHelpOptions = true)
public class AddCommand implements Runnable {

	@Parameters(paramLabel = "TITLE", description = "Quick create a topic with just title")

	@Option(names = { "-t", "--title" }, description = "Specify the title to add")
	String title;

	@Override
	public void run() {
		// TODO: If both parameter and option are null throw error
	}

}
