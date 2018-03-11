package com.bac.file_copy_move;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileMoveTest {
	
	public static void main(String[] args) {
		Path moveFrom = FileSystems.getDefault().getPath("C:\\java_nio_dir", "temp_files", "Akhter_6184614356245503927_copy(4).txt");
		Path moveTo =   FileSystems.getDefault().getPath("C:\\java_nio_dir", "Akhter_6184614356245503927_copy_moved.txt");
		
		try {
			Path movedFile = Files.move(moveFrom, moveTo, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Moved File name:"+movedFile);
			Thread.sleep(10000);
			boolean isFileDeleted = Files.deleteIfExists(movedFile);
			System.out.println("Moved file deleted:"+isFileDeleted);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
