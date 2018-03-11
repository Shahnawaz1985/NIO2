package com.bac.file_dir;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileOperationTest2 {
	public static void main(String[] args) {
		Path file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		List<String> fileContents = new ArrayList<String>();
		fileContents.add("\n\n");
		fileContents.add("First Line added in sample_file1.txt");
		fileContents.add("Second Line added in sample_file1.txt");
		fileContents.add("Third Line added in sample_file1.txt");
		fileContents.add("Fourth Line added in sample_file1.txt");
		fileContents.add("Fifth Line added in sample_file1.txt");
		fileContents.add("Sixth Line added in sample_file1.txt");
		fileContents.add("Seventh Line added in sample_file1.txt");
		fileContents.add("Eights Line added in sample_file1.txt");
		Charset charset = Charset.forName("UTF-8");
		
		try {
			Path updated_file_path = Files.write(file_path, fileContents, charset, StandardOpenOption.APPEND);
			System.out.println(updated_file_path);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
