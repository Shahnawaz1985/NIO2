package com.bac.file_dir;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileOperationTest4 {
	
	public static void main(String[] args) {
		Path file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		Charset charset = Charset.forName("UTF-8");
		
		try {
			List<String> fileContents = Files.readAllLines(file_path, charset);
			//System.out.println(fileContents);
			for(String content : fileContents) {
				System.out.println(content);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
