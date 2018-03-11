package com.bac.sample.links;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class LinkTest {
	
	public static void main(String[] args) {
		Path target = FileSystems.getDefault().getPath("D:/test.jpeg");
		Path link = FileSystems.getDefault().getPath("test_ln.1");
		
		try {
			Files.createSymbolicLink(link, target);
		}catch(IOException | UnsupportedOperationException | SecurityException e) {
			if(e instanceof IOException) {
				System.out.println("An I/O error:");
				e.printStackTrace();
			}
			if(e instanceof UnsupportedOperationException) {
				System.out.println("An UnsupportedOperationException error");
				e.printStackTrace();
			}
			if(e instanceof SecurityException) {
				System.out.println("Permission denied.");
				e.printStackTrace();
			}
		}
	}

}
