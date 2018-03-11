package com.bac.file_copy_move;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileRenameTest {
	
	public static void main(String[] args) {
		Path originalFile = FileSystems.getDefault().getPath("C:\\java_nio_dir", "Akhter_1065683481301167421", "Akhter_780412259536943790_Copy.txt");
		
		try {
			Path renamedFile = Files.move(originalFile, originalFile.resolveSibling("sibling.txt"), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("is File renamed:"+renamedFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
