package com.bac.file_dir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperation_BufferedReadrWriter {
	
	public static void main(String[] args) {
		Path file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		Charset charset = Charset.forName("UTF-8");
		String test_string = "\n\nShahnawaz Akhter";
		
		try(BufferedWriter writer = Files.newBufferedWriter(file_path, StandardOpenOption.APPEND)){
			writer.write(test_string);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader reader = Files.newBufferedReader(file_path, charset)){
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
