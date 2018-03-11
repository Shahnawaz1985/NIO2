package com.bac.file_dir;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAccessibilityTest {
	
	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath("C:/application_logs/spring_jta_transaction/transaction.log");
		System.out.println("is_readable:"+Files.isReadable(path));
		System.out.println("is_executable:"+Files.isExecutable(path));
		System.out.println("is_writable:"+Files.isWritable(path));
		System.out.println("is_regular:"+Files.isRegularFile(path));
		
		
		Path path1 = FileSystems.getDefault().getPath("C:/application_logs/spring_jta_transaction","transaction.log");
		
		try {
			System.out.println("is_hidden:"+Files.isHidden(path));
			System.out.println("is same file path & path1:"+Files.isSameFile(path, path1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
