package com.bac.file_dir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationTest {
	
	public static void main(String[] args) {
		Path file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		
		String content = "This is sample string for sample_file1.txt";
		
		try {
			byte[] text_bytes = content.getBytes("UTF-8");
			Files.write(file_path, text_bytes);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
