package com.bac.sample.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.List;

public class ACLFileAttributeTest {
	
	public static void main(String[] args) {
		Path path = Paths.get("C:/application_logs/spring_jta_transaction/transaction.log");
		List<AclEntry> aclList = null;
		AclFileAttributeView aclView = null;
		aclView = Files.getFileAttributeView(path, AclFileAttributeView.class);
		try {
			aclList = aclView.getAcl();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(AclEntry acl: aclList) {
			System.out.println("**********************************************");
			System.out.println("Principal :"+acl.principal());
			System.out.println("Type :"+acl.type());
			System.out.println("Permission :"+acl.permissions());
			System.out.println("Flags :"+acl.flags().toString());			
		}
	}
}
