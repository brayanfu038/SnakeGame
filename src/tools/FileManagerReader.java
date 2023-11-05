package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManagerReader {
	File file;
	FileReader fr;
	BufferedReader bw;
	ArrayList<String> lines;
	ArrayList<String []>niveles;
	
	public FileManagerReader(String path, String name) throws FileNotFoundException {
		file = new File(path + name + ".txt");
		fr = new FileReader(file);
		bw = new BufferedReader(fr);
		lines = new ArrayList();
		niveles = new ArrayList();

	}

	public void readFile() throws IOException {

		String str = "";
		while ((str = bw.readLine()) != null) {
			lines.add(str + "\n");
		}
	}
	
	public void getlvls() {
		String[] split;
		for (int i = 0; i < lines.size(); i++) {
			split = lines.get(i).split(";");
			niveles.add(split);
		}

	}

	public ArrayList<String[]> getNiveles() {
		return niveles;
	}

	public void setNiveles(ArrayList<String[]> niveles) {
		this.niveles = niveles;
	}

	public ArrayList<String> getLines() {
		return lines;
	}

public void setLines(ArrayList<String> lines) {
		this.lines = lines;
}
}
