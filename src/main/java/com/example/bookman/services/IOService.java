package com.example.bookman.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.example.bookman.config.AppConfig;
import com.example.bookman.config.FileType;
import com.example.bookman.models.Topic;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class IOService {

	public static ArrayList<Topic> importFromFile(String fileName) {
		Path filePath = Paths.get(fileName).toAbsolutePath().normalize();

		FileType fileImportType = resolveFileTypeFromFileName(fileName);

		ArrayList<Topic> topics;
		switch (fileImportType) {
		case JSON:
			topics = importFromJson(filePath);
			break;
		case CSV:
			topics = importFromCsv(filePath);
			break;
		case XML:
			topics = importFromXml(filePath);
			break;
		default:
			topics = importFromJson(filePath);
		}

		return topics;
	}

	public static boolean exportToFile(ArrayList<Topic> topicsList) {
		return exportToFile(topicsList, null, FileType.UNDEFINED);
	}

	public static boolean exportToFile(ArrayList<Topic> topicsList, String fileName) {
		return exportToFile(topicsList, fileName, FileType.UNDEFINED);
	}

	public static boolean exportToFile(ArrayList<Topic> topicsList, String fileName, FileType fileExportType) {

		if (fileExportType == FileType.UNDEFINED)
			fileExportType = resolveFileTypeFromFileName(fileName);

		Path filePath = resolveFileName(fileName, fileExportType);

		switch (fileExportType) {
		case JSON:
			exportToJson(topicsList, filePath);
			break;
		case CSV:
			exportToCsv(topicsList, filePath);
			break;
		case XML:
			exportToXml(topicsList, filePath);
			break;
		default:
			exportToJson(topicsList, filePath);
		}
		return true;
	}

	private static FileType resolveFileTypeFromFileName(String fileName) {

		if (fileName == null || fileName.isEmpty()) {
			return FileType.UNDEFINED;
		}

		int lastDotIndex = fileName.lastIndexOf('.');

		// No dot OR dot is at start (like ".gitignore")
		if (lastDotIndex == -1 || lastDotIndex == 0 || lastDotIndex == fileName.length() - 1) {
			return FileType.UNDEFINED;
		}

		String exportType = fileName.substring(lastDotIndex + 1).toUpperCase();
		FileType fileExportType;

		try {
			fileExportType = FileType.valueOf(exportType);
		} catch (IllegalArgumentException e) {
			System.out.println("WARNING! Couldn't resolve fileExportType from fileName, going default!");
			fileExportType = FileType.UNDEFINED;
		}

		return fileExportType;
	}

	private static Path resolveFileName(String fileName, FileType fileExportType) {
		String resolvedName = null;
		String fileExtension = ".".concat(fileExportType.toString().toLowerCase());

		if (fileName != null && !fileName.isBlank()) {
			resolvedName = fileName.endsWith(fileExtension) ? fileName : fileName + fileExtension;
		} else {
			if (resolvedName == null || resolvedName.isBlank()) {
				resolvedName = System.getenv("BOOKMAN_EXPORT_DEFAULT_FILE");
			}

			if (resolvedName == null || resolvedName.isBlank()) {
				resolvedName = AppConfig.EXPORT_DEFAULT_FILE_NAME;
			}
			
			resolvedName += fileExtension;
		}

		Path filePath = Paths.get(resolvedName).toAbsolutePath().normalize();

		return filePath;
	}

	public static ArrayList<Topic> importFromJson(Path filePath) {

		ArrayList<Topic> topics = new ArrayList<Topic>();
		try {
			topics = new ObjectMapper().readerForListOf(Topic.class).readValue(filePath.toFile());
		} catch (IOException e) {
			System.out.println("Unable to deserialize JSON for BookMan");
			e.printStackTrace();
			System.exit(1);
		}

		return topics;
	}

	public static ArrayList<Topic> importFromCsv(Path filePath) {
		// TODO Implementation: importFromCsv()
		return null;
	}

	public static ArrayList<Topic> importFromXml(Path filePath) {
		// TODO Implementation: importFromXml()
		return null;
	}

	public static boolean exportToJson(ArrayList<Topic> topicsList, Path filePath) {

		try {
			if (filePath.getParent() != null) {
				Files.createDirectories(filePath.getParent());
			}

			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

			writer.writeValue(filePath.toFile(), topicsList);

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static boolean exportToCsv(ArrayList<Topic> topicsList, Path filePath) {
		// TODO: Implementation: exportToCsv()
		return true;
	}

	public static boolean exportToXml(ArrayList<Topic> topicsList, Path filePath) {
		// TODO: Implementation: exportToCsv()
		return true;

	}
}