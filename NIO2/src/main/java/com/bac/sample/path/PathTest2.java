package com.bac.sample.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest2 {
	
	public static void main(String[] args) {
		Path path1 = Paths.get(System.getProperty("user.home"), "downloads");
		Path path2 = path1.resolve("AWB.pdf");
		Path path3 = path1.resolve("DCompiler.jar");
		
		Path relative_path_1 = path2.relativize(path3);
		System.out.println(relative_path_1);
		
		Path relative_path_2 = path3.relativize(path2);
		System.out.println(relative_path_2);
		
		Path path4 = Paths.get("C:/Users/Qais/Downloads/AWB.pdf");
		
		if(path4.equals(path2)) {
			System.out.println("Same file.");
		}else {
			System.out.println("Different File.");
		}
	}

}
