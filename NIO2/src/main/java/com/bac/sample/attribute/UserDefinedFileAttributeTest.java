package com.bac.sample.attribute;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class UserDefinedFileAttributeTest {
	
	public static void main(String[] args) {
		Path path = Paths.get("C:/application_logs/spring_jta_transaction/transaction.log");
		FileStore fStore = null;
		UserDefinedFileAttributeView udaf = null;
		try {
			fStore = Files.getFileStore(path);
			if(!fStore.supportsFileAttributeView(UserDefinedFileAttributeView.class)) {
				System.out.println("UserDefinedFileAttributeView not supported.");
			}else {
				System.out.println("UserDefinedFileAttributeView supported.");
			}
			udaf = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			for(String name : udaf.list()) {
				System.out.println(udaf.size(name)+"  "+name);
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
