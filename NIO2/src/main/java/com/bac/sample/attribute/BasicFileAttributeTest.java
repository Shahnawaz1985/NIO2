package com.bac.sample.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributeTest {
	
	public static void main(String[] args) {
		BasicFileAttributes attr = null;
		Path path = Paths.get("C:/application_logs/spring_jta_transaction/transaction.log");
		try {
			attr = Files.readAttributes(path, BasicFileAttributes.class);			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		System.out.println("File size:"+attr.size()/1024+"kb");
		System.out.println("File creation time:"+attr.creationTime());
		System.out.println("File last accessed:"+attr.lastAccessTime());
		System.out.println("File modified at:"+attr.lastModifiedTime());
		System.out.println("Is Directory:"+attr.isDirectory());
		System.out.println("Is regular file:"+attr.isRegularFile());
		System.out.println("Is symbolic link:"+attr.isSymbolicLink());
		System.out.println("Is other:"+attr.isOther());		
	}

}
