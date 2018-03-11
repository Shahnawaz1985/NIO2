package com.bac.file_copy_move;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopy_OutputStream {
	
	public static void main(String[] args) {
		Path copyFrom = FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_6184614356245503927.txt");
		Path copyTo =   FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_6184614356245503927_copy(3).txt");
		try(OutputStream os = new FileOutputStream(copyTo.toFile())){
			long file_bytes = Files.copy(copyFrom, os);
			System.out.println("File bytes copied :"+file_bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
