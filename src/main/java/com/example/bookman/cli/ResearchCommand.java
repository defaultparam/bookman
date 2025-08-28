package com.example.bookman.cli;

import com.example.bookman.models.TopicCategory;
import com.example.bookman.services.CategoryService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "research", description = "Add or List topics related to work", subcommands = {
		AddCommand.class }, mixinStandardHelpOptions = true)
public class ResearchCommand implements Runnable {

	private final CategoryService _categorySrv;
	
	public ResearchCommand(CategoryService categorySrv) {
		this._categorySrv = categorySrv;
	}
	
	@Option(names = { "-l", "--list" }, description = "Lists all the topics related to research category")
	boolean viewResearchTopics;

	@Override
	public void run() {
		if (viewResearchTopics) {
			
			String json = _categorySrv.listByCategory(TopicCategory.RESEARCH);
			// TODO: Implement a console out!
			System.out.println(json);
		}
	}

}
