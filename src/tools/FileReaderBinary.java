package tools;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReaderBinary {
	//File file;
	FileInputStream read;
	DataInputStream input;
	public FileReaderBinary(String path) throws IOException {
		//file = new File(path);
		read = new FileInputStream(path);
		input = new DataInputStream (read);
	}
	public int readInt() throws ClassNotFoundException, IOException {
		return input.read();
	}
	public void close() throws IOException {
		input.close();
	}
	public String readString() throws IOException {
		return input.readUTF();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileReaderBinary fr = new FileReaderBinary("Resources\\numbers.num");
		System.out.println(fr.readInt());
	}
	
}
