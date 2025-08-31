package com.example.bookman;

import com.example.bookman.cli.BookmanCommand;

import picocli.CommandLine;

public class Application {

	public static void main(String[] args) {
		int exitCode = new CommandLine(new BookmanCommand()).execute(args);
		System.exit(exitCode);
	}
}
