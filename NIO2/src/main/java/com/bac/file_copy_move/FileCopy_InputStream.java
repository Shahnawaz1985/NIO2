package com.bac.file_copy_move;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopy_InputStream {
	
	public static void main(String[] args) {
		Path copyFrom = FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_6184614356245503927.txt");
		Path copyTo =   FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_6184614356245503927_copy(2).txt");
		
		try(InputStream is = new FileInputStream(copyFrom.toFile())){
			long copied_file_bytes = Files.copy(is, copyTo, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Size of file copied:"+copied_file_bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();			
		}
	}

}
