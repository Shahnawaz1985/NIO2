package com.bac.file_dir;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryOperationTest {
	
	public static void main(String[] args) {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for(Path path : dirs) {
			System.out.println(path);
		}
		/*System.out.println("-----");
		File[] roots = File.listRoots();
		for(File f:roots) {
			System.out.println(f);
		}*/
		
		Path newDirPath = FileSystems.getDefault().getPath("C:/java_nio_dir");
		
		try {
			Path path = Files.createDirectories(newDirPath);
			System.out.println("Succesfully created dir:"+path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path dir_path = Paths.get("C:/");
		try(DirectoryStream<Path> ds = Files.newDirectoryStream(dir_path)){
			for(Path p : ds) {
				System.out.println(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path dir_content = Paths.get("C:/application_logs/spring_jta_transaction");
		try(DirectoryStream<Path> dir_conts = Files.newDirectoryStream(dir_content, "*.{log,}")){ //"*.{log,jpg,log.*}
			for(Path p : dir_conts) {
				System.out.println(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
