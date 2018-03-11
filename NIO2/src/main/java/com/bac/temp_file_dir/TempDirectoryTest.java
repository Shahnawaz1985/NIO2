package com.bac.temp_file_dir;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.DirectoryStream;

public class TempDirectoryTest {
	
	public static void main(String[] args) {
		String temp_dir_prefix = "Shahnawaz_";
		String tmp_dir_loc = System.getProperty("java.io.tmpdir");
		System.out.println("Temporary directory configured:"+tmp_dir_loc);
		Path configured_tmp_dir = Paths.get(tmp_dir_loc);
		try {
			Path tmp1 = Files.createTempDirectory(null);
			System.out.println(tmp1.toString());
			Path tmp2 = Files.createTempDirectory(temp_dir_prefix);
			System.out.println(tmp2.toString());
			Runtime.getRuntime().addShutdownHook(new Thread() {
				
				public void run() {
					System.out.println("Deleting temorary folders...");
					try(DirectoryStream<Path> directories = Files.newDirectoryStream(configured_tmp_dir)){
						for(Path pt : directories) {
							if(pt.toString().contains(temp_dir_prefix)) {
								System.out.println(pt.toString());
								Files.delete(pt);
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path base_dir = FileSystems.getDefault().getPath("C:\\java_nio_dir", "Akhter_1065683481301167421");
		String temp_prefix = "Akhter_";
		
		try {
			Path tmp1 = Files.createTempDirectory(base_dir, temp_prefix);
			System.out.println(tmp1.toString());
			Runtime.getRuntime().addShutdownHook(new Thread() {
				
				public void run() {
					System.out.println("Deleting temorary folders...");
					try(DirectoryStream<Path> directories = Files.newDirectoryStream(base_dir)){
						for(Path pt : directories) {
							if(pt.toString().contains(temp_prefix)) {
								System.out.println(pt.toString());
								Files.delete(pt);
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Temp directory deleted successfully.");
				}
			});
			Thread.sleep(1000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
