package com.bac.sample.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;

public class POSIXFileAttributeTest {
	
	public static void main(String[] args) {
		Path path = Paths.get("C:/application_logs/spring_jta_transaction/transaction.log");
		PosixFileAttributes attr = null;
		try{
			attr = Files.readAttributes(path, PosixFileAttributes.class);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		if(null != attr) {
			System.out.println("File owner:"+attr.owner().getName());
			System.out.println("File group:"+attr.group().getName());
			System.out.println("File pwemission:"+attr.permissions().toString());
		}else {
			System.out.println("PosixFileAttributes object is null");
		}
				
	}

}
