package allchapters;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class EdIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUtils fU = new FileUtils();
		//fU.copyTextToDest();
		//fU.copyBinaryToDest();
		fU.copyNIO2TextToDest();
		fU.copyNIO2BinaryToDest();

	}

}

class FileUtils {
	void copyNIO2TextToDest() {
		Path src = Paths.get("resources/Zoo.txt");
		Path dest = Paths.get("resources/ZooNIO2CopyText.txt");
		fileNIO2CopyBuffered(src, dest);
	}
	
	void copyNIO2BinaryToDest() {
		Path src = Paths.get("resources/ADeque.class");
		Path dest = Paths.get("resources/ADequeNIO2CopyBinary.class");
		fileNIO2CopyBinaryBuffered(src, dest);
	}
	
	void copyBinaryToDest() {
		File src = new File("resources/ADeque.class");
		File dest = new File("resources/ADequeCopy.class");
		fileStreamCopyBuffered(src, dest);
	}
	
	void copyTextToDest() {
		File src = new File("resources/Zoo.txt");
		File dest = new File("resources/ZooCopyText.txt");
		fileCopyBuffered(src, dest);
	}
	
	void fileStream(File source, File dest) {
		try (
				InputStream in = new FileInputStream(source);
				OutputStream out = new FileOutputStream(dest)
			) {
			int i;
			while ((i = in.read()) != -1) {
				out.write(i);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	void fileStreamCopyBuffered(File source, File dest) {
		try (
				InputStream in = new BufferedInputStream (new FileInputStream(source));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(dest))
			) {
			byte[] buff = new byte[1024];
			int lengthRead;
			while ((lengthRead = in.read(buff)) > 0) {
				System.out.println("Buffered stream read/wrote: " + lengthRead);
				out.write(buff,0,lengthRead);
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	void fileCopyBuffered(File source, File dest) {
		try (
				BufferedReader in = new BufferedReader (new FileReader(source));
				BufferedWriter out = new BufferedWriter(new FileWriter(dest))
			) {
			String s;
			while ((s = in.readLine()) != null) {
				out.write(s);
				out.newLine();
				System.out.println("Buffered file read/wrote: " + s);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	void fileNIO2CopyBuffered(Path source, Path dest) {
		try (
				BufferedReader in = Files.newBufferedReader(source,Charset.forName("UTF-8"));
				BufferedWriter out = Files.newBufferedWriter(dest,Charset.forName("UTF-8"));
			) {
			String s;
			while ((s = in.readLine()) != null) {
				out.write(s);
				out.newLine();
				System.out.println("NIO2 Buffered file read/wrote: " + s);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	void fileNIO2CopyBinaryBuffered(Path source, Path dest) {
		try (
				BufferedReader in = Files.newBufferedReader(source,Charset.forName("UTF-8"));
				BufferedWriter out = Files.newBufferedWriter(dest,Charset.forName("UTF-8"));
			) {
			
				byte[] bytes = Files.readAllBytes(source);
				Files.write(dest, bytes);
				System.out.println("NIO2 Buffered file read/wrote: " + bytes.length);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	/*
	void fileNIO2CopyBinaryBuffered(Path source, Path dest) {
		try (
				BufferedReader in = Files.newBufferedReader(source,Charset.forName("UTF-8"));
				BufferedWriter out = Files.newBufferedWriter(dest,Charset.forName("UTF-8"));
			) {
				Stream<String> sIn = in.lines().collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	*/


}
