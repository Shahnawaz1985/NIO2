package com.bac.file_dir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperatoin_UnBufferedReader {
	public static void main(String[] args) {
		Path file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		try(InputStream in = Files.newInputStream(file_path)){
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nnewInputStream usage with byte buffer.");
		file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		int n;
		byte[] byte_buffer = new byte[1024];
		String str = null;
		try(InputStream stream = Files.newInputStream(file_path)) {
			while((n = stream.read(byte_buffer)) != -1) {
				str = new String(byte_buffer);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
