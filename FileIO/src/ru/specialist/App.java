package ru.specialist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;

import java.util.zip.*;

import static java.lang.System.out;

public class App {
	
	// ../test1.txt
	public static final String fileName1 = 
			".." + File.separator + "test1.txt";
	
	public static final String fileName2 =
			".." + File.separator + "test2.txt";
	
	// ../
	public static final String dir1 = ".." + File.separator;

	public static void main(String[] args) throws IOException {
		File f1 = new File(fileName1);
		if (!f1.exists())
			f1.createNewFile();
		
		Date lm = new Date(f1.lastModified());
		out.println(lm.toLocaleString());
		out.println(f1.getCanonicalPath());
		
		File d1 =  new File(dir1);
		out.println(d1.getCanonicalPath());
		
		File[] files = d1.listFiles();
		for(File file : files) {
			if (file.isDirectory())
				out.println(file.getName().toUpperCase());
			if (file.isFile())
				out.println(file.getName().toLowerCase());
		}
		
//		FileInputStream fin = new FileInputStream(fileName1);
//		var buf = new byte[1000];
//		fin.read(buf);
//		fin.close();
		
//		FileInputStream fin = null;
//		BufferedReader reader = null;
//		try {
//			fin = new FileInputStream(fileName1);
//			reader = new BufferedReader(new InputStreamReader(fin/*, Charset.forName("cp1251")*/)); // utf-8
//			String line = null;
//			while ( (line = reader.readLine()) != null )
//				out.println(line);
//		}
//		catch(IOException ex) {
//			System.err.println(ex.getMessage());
//		}
		
//		finally {
//			if (reader!=null) reader.close();
//			if (fin!=null) fin.close();
//		}
		
		// ресурсный try
		try( var fin = new FileInputStream(fileName1);
			 var reader = new BufferedReader(new InputStreamReader(fin)) ) // interface Closeable или AutoCloseable
		{
				String line = null;
				while ( (line = reader.readLine()) != null )
					out.println(line);
		} // reader.close(); fin.close();
		
		
		try (	var fout = new FileOutputStream(fileName2);
				var writer = new PrintWriter(fout, false, Charset.forName("cp1251") ) )
		{
		
			writer.printf("%-20s : %d\n", "Java 1 - Основы", 40);
			// writer.flush();
			writer.printf("%-20s : %d\n", "Java 2 - ООП", 40);
			writer.printf("%-20s : %d\n", "Git", 16);
		} // writer.close(); fout.close();
		
		ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("../test.zip"));
		ZipEntry entry = new ZipEntry("data.txt");
		
		zip.putNextEntry(entry);
		
		zip.close();
		
		

	}

}
