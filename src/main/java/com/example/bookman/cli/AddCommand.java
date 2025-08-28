package com.example.bookman.cli;

import com.example.bookman.models.TopicCategory;
import com.example.bookman.services.CategoryService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@Command(name = "add", description = "Add a topic to the category", mixinStandardHelpOptions = true)
public class AddCommand implements Runnable {
	
	
//	public AddCommand(CategoryService categorySrv) {
//		this.categorySrv = categorySrv;
//	}

	@Parameters(paramLabel = "TITLE", description = "Quick create a topic with just title")
	String paramTitle;
	@Option(arity = "1", names = { "-t", "--title" }, description = "Specify the title to add")
	String optionTitle;

	@Option(arity = "1..*", names = { "-n", "--notes", "--description", }, description = "Specify subtitle to the topic (if any)")
	String notes;

	@Spec
	CommandSpec commandSpec;

	@Override
	public void run() {
		String title = paramTitle.isBlank() ? optionTitle : paramTitle;
		
		if (title.isBlank()) {
			System.out.println("NO TITLE PROVIDED");
			return;
		}
		
		String parentCommand = commandSpec.parent().name();
		TopicCategory category = TopicCategory.valueOf(parentCommand);
		System.out.println(category);
//		boolean isSuccess = categorySrv.addTopicToCategory(title, category, notes);
//		if (isSuccess) {
//			System.out.println("Topic added successfully!");
//		}
//		else {
//			System.out.println("Add error handling");
//		}
	}
}
