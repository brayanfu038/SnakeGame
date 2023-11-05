package tools;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileWriterBinary {
	File file;
	FileOutputStream write;
	DataOutputStream outPut;
	public FileWriterBinary(String path) throws IOException {
		file = new File(path);
		write = new FileOutputStream(path);
		outPut = new DataOutputStream (write);
	}
	public void writeInt(int i) throws IOException {
		outPut.writeInt(i);
	}
	public void closeAll() throws IOException {
		outPut.close();
	}
	public boolean exist() {
		return file.exists();
	}
}
