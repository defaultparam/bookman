package com.example.bookman.cli;

import com.example.bookman.utils.VersionProvider;

import picocli.CommandLine;
import picocli.CommandLine.Command;
//import picocli.CommandLine.Option;

@Command(name = "bookman", 
	description = "Simple CLI app to track your topics", 
	subcommands = {TopicCommand.class, ResearchCommand.class, LifestyleCommand.class, CommandLine.HelpCommand.class},
	versionProvider = VersionProvider.class,
	mixinStandardHelpOptions = true)
public class BookmanCommand {
	
}
