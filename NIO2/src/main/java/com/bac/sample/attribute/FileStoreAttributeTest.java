package com.bac.sample.attribute;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStoreAttributeTest {
	
	public static void main(String[] args) {
		Path path = Paths.get("C:/application_logs/spring_jta_transaction/transaction.log");
		FileSystem fs = FileSystems.getDefault();
		for(FileStore fStore : fs.getFileStores()) {
			try {
				long totalSpace = fStore.getTotalSpace();
				long used_space = fStore.getTotalSpace() - fStore.getUnallocatedSpace();
				long available_space = fStore.getUsableSpace();
				boolean is_read_only = fStore.isReadOnly();
				
				System.out.println("----------------"+fStore.name()+"-----------------------"+fStore.type());
				System.out.println("Total space :"+((totalSpace/1024)/1024)/1024+"GB.");
				System.out.println("Used space :"+((used_space/1024)/1024)/1024+"GB.");
				System.out.println("Available space :"+((available_space/1024)/1024)/1024+"GB.");
				System.out.println("is_read_only :"+is_read_only);
			}catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		try {
			FileStore fStore = Files.getFileStore(path);
			long totalSpace = fStore.getTotalSpace();
			long used_space = fStore.getTotalSpace() - fStore.getUnallocatedSpace();
			long available_space = fStore.getUsableSpace();
			boolean is_read_only = fStore.isReadOnly();
			System.out.println("----------------"+fStore.name()+"-----------------------"+fStore.type());
			System.out.println("Total space :"+((totalSpace/1024)/1024)/1024+"GB.");
			System.out.println("Used space :"+((used_space/1024)/1024)/1024+"GB.");
			System.out.println("Available space :"+((available_space/1024)/1024)/1024+"GB.");
			System.out.println("is_read_only :"+is_read_only);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
