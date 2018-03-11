package com.bac.sample.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;


public class DOSFileAttributeTest {
	
	public static void main(String[] args) {
		DosFileAttributes attrs = null;
		Path path = Paths.get("C:/application_logs/spring_jta_transaction/transaction.log");
		try {
			attrs = Files.readAttributes(path, DosFileAttributes.class);			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("File isArchive:"+attrs.isArchive());
		System.out.println("File isHidden:"+attrs.isHidden());
		System.out.println("File isReadOnly:"+attrs.isReadOnly());
		System.out.println("File isSystem:"+attrs.isSystem());
		
		try {
			Files.setAttribute(path, "dos:readonly", true, NOFOLLOW_LINKS);
			Files.setAttribute(path, "dos:hidden", true, NOFOLLOW_LINKS);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		System.out.println("File isReadOnly:"+attrs.isReadOnly());
		System.out.println("File isHidden:"+attrs.isHidden());
		
		
		try {
			Files.setAttribute(path, "dos:readonly", false, NOFOLLOW_LINKS);
			Files.setAttribute(path, "dos:hidden", false, NOFOLLOW_LINKS);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		System.out.println("File isReadOnly:"+attrs.isReadOnly());
		System.out.println("File isHidden:"+attrs.isHidden());
		
	}
}
