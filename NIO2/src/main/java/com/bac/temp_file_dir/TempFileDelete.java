package com.bac.temp_file_dir;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempFileDelete {
	
	public static void main(String[] args) {
		Path base_path = FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_3947220504366370397.txt");
		
		try {
			boolean file_delete_flag = Files.deleteIfExists(base_path);
			System.out.println("File deletion:"+file_delete_flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
