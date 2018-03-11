package com.bac.sample.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("PathTest.java");
		System.out.println(path.getFileName());
		System.out.println(path.toAbsolutePath());
		
		System.out.println(path.getFileSystem().getSeparator());
		System.out.println("File System supported File Attribute View:"+path.getFileSystem().supportedFileAttributeViews());
		
		Path path2 = Paths.get(System.getProperty("user.home"), "downloads", "apache-activemq-5.8.0-bin.zip");
		System.out.println(path2);
		System.out.println(path2.toUri());
		System.out.println(path2.getParent());
		System.out.println(path2.getNameCount());
		System.out.println("Subpath(0,2):"+path2.subpath(0, 2));
		System.out.println(path2.getFileName());
		System.out.println(path2.getFileSystem().getFileStores());
		System.out.println(path2.getRoot());
		System.out.println(path2.toRealPath(LinkOption.NOFOLLOW_LINKS));
		
		File file_path = path2.toFile();
		System.out.println("File path:"+file_path.toString());
		
		Path path3 = Paths.get(System.getProperty("user.home"), "downloads");
		Path path4 = path3.resolve("AWB.pdf");
		System.out.println(path4);
		System.out.println(path4.toRealPath(LinkOption.NOFOLLOW_LINKS));
		Path path5 = path4.resolveSibling("DCompiler.jar");
		System.out.println(path5);
		System.out.println(path5.toRealPath(LinkOption.NOFOLLOW_LINKS));
	}

}
