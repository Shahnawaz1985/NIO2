package com.bac.sample.attribute;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

import java.io.IOException;

public class FileOwnerAttributeTest {
	
	public static void main(String[] args) {
		Path path = Paths.get("C:/application_logs/spring_jta_transaction/transaction.log");
		UserPrincipal owner = null;
		FileOwnerAttributeView foav = null;
		try {
			owner = (UserPrincipal) Files.getAttribute(path, "owner:owner", NOFOLLOW_LINKS);
			System.out.println("User Principal:"+owner.getName());//Developer-PC\Qais
			foav = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
			String role_owner = foav.getOwner().getName();
			System.out.println("FileOwnerAttributeView role:"+role_owner);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
