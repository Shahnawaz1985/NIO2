package com.bac.file_dir;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

public class DirectoryOperationFilterTest {
	
	public static void main(String[] args) {
		Path dir_paths = FileSystems.getDefault().getPath("C:/DEV_SOFTWARES");
		
		DirectoryStream.Filter<Path> dir_filter = new DirectoryStream.Filter<Path>() {

			@Override
			public boolean accept(Path entry) throws IOException {
				return Files.isDirectory(entry, NOFOLLOW_LINKS);
			}
			
		};
		
		System.out.println("Directory Listings:");
		try(DirectoryStream<Path> dir_conts = Files.newDirectoryStream(dir_paths, dir_filter)){ //"*.{log,jpg,log.*}
			
			for(Path p : dir_conts) {
				System.out.println(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
