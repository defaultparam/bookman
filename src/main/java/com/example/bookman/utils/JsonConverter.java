package com.example.bookman.utils;

import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class JsonConverter {
	public static <T> String Serialize(T object) {
		var gson = new GsonBuilder().setPrettyPrinting().create();
		
		return gson.toJson(object);
	}
	
	public static <T> T Deserialize(String jsonString, Type typeofT) {
		var gson = new GsonBuilder().create();
		
		return gson.fromJson(jsonString, typeofT);
	}
}
