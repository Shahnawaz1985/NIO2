package com.bac.temp_file_dir;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFileTest {
	
	public static void main(String[] args) {
		Path base_dir = FileSystems.getDefault().getPath("C:\\java_nio_dir", "Akhter_1065683481301167421");
		String temp_file_prefix = "Akhter_";
		String temp_file_suffix = ".txt";
		
		try {
			final Path temp_file = Files.createTempFile(base_dir, temp_file_prefix, temp_file_suffix);
			System.out.println("Temporary file:"+temp_file);
			
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					System.out.println("Deleting temporary files");
					try {
						Files.delete(temp_file);
						System.out.println(temp_file+ " deletion successful.");
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Shutdown hook completed.");
				}
			});
			Thread.sleep(1000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
