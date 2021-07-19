package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFieldManager {

	public ArrayList<String> readFile(String nameList) throws IOException{
		ArrayList<String> linesRead = new ArrayList<>();
		FileReader fileReader = new FileReader(nameList);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String lineRead;
		
		while(( lineRead = bufferedReader.readLine() ) != null) {
			linesRead.add(lineRead);
		}
		bufferedReader.close();
		return linesRead;
	}
	
	public void writeFile(String nameList,ArrayList<String> datas) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(nameList);
			for (String data : datas) {
				fileWriter.write(data + "\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
