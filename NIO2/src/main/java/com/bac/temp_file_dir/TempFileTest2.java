package com.bac.temp_file_dir;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TempFileTest2 {
	
	public static void main(String[] args) {
		Path base_dir = FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files");
		String temp_file_prefix = "Akhter_";
		String temp_file_suffix = ".txt";
		
		Path temp_file = null;
		
		try {
			temp_file = Files.createTempFile(base_dir, temp_file_prefix, temp_file_suffix);
			System.out.println(temp_file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(OutputStream os = Files.newOutputStream(temp_file, StandardOpenOption.DELETE_ON_CLOSE)){
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
			writer.write("Content for temporary file.");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
