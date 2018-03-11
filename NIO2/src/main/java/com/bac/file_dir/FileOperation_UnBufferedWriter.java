package com.bac.file_dir;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperation_UnBufferedWriter {
	
	public static void main(String[] args) {
		Path file_path = Paths.get("C:\\java_nio_dir", "sample_file1.txt");
		String new_string_content = "\nFile operation using unbuffered writers";
		byte[] data =new_string_content.getBytes(Charset.forName("UTF-8"));
		BufferedWriter writer = null;
		try(OutputStream outputStream = Files.newOutputStream(file_path, StandardOpenOption.APPEND)){
			outputStream.write(data);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		String str = "\nNew content added with unbuffered writer\n";
	
		try(OutputStream outputStream = Files.newOutputStream(file_path, StandardOpenOption.APPEND)){
			writer = new BufferedWriter(new OutputStreamWriter(outputStream));
			writer.write(str);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
