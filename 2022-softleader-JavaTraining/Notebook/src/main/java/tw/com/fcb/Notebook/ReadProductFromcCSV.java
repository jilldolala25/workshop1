package tw.com.fcb.Notebook;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class ReadProductFromcCSV {

	public Map<String, NoteBook> readProductFromSCV() throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader("notebook-Info.csv"));

		List<NoteBook> noteBooks = new ArrayList<NoteBook>();
		List<String[]> records = reader.readAll();
		Iterator<String[]> iterator = records.iterator();
		Map<String,NoteBook> myNotebook = new HashMap<String,NoteBook>();
		while(iterator.hasNext()){
			var record = iterator.next();
			NoteBook notebook = new NoteBook();
			notebook.setProductNo(record[0]);
			notebook.setBrand(record[1]);
			notebook.setCpu(record[2]);
			notebook.setScreenSize(record[3]);
			notebook.setMemory(record[4]);
			notebook.setStorage(record[5]);
			notebook.setColor(record[6]);
			notebook.setPrice(Integer.parseInt(record[7]));
			noteBooks.add(notebook);
			myNotebook.put(notebook.getProductNo(), notebook);
		}

		return myNotebook;


	}


}

	

