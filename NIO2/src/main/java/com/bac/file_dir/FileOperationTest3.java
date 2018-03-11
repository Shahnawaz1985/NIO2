package com.bac.file_dir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperationTest3 {
	
	public static void main(String[] args) {
		Path file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		try {
			byte[] byte_array = Files.readAllBytes(file_path);
			String contents = new String(byte_array, "UTF-8");
			System.out.println(contents);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
