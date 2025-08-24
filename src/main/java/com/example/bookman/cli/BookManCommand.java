package com.example.bookman.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
//import picocli.CommandLine.Option;

@Command(name = "bookman", 
	description = "Simple CLI app to track your topics", 
	subcommands = {TopicCommand.class, CommandLine.HelpCommand.class},
	version = "0.0.1",
	mixinStandardHelpOptions = true)
public class BookmanCommand {
	
}
