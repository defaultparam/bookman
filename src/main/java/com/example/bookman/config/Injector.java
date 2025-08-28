package com.example.bookman.config;

import com.example.bookman.services.IOService;
import com.example.bookman.services.CategoryService;

public class Injector {
	public static IOService getIoService() {
		return new IOService();
	}
	
	public static CategoryService getCategoryService(IOService ioSrv) {
		return new CategoryService(ioSrv);
	}
}
