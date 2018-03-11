package com.bac.file_copy_move;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

public class FileCopyTest {
	
	public static void main(String[] args) {
		Path copyFrom = FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_6184614356245503927_copy.txt");
		Path copyTo =   FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_6184614356245503927_copy(4).txt");
		
		try {
			Path new_copied_path = Files.copy(copyFrom, copyTo, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
			System.out.println("Copied File name:"+new_copied_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
