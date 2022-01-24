package tw.com.fcb.Notebook;

import com.opencsv.exceptions.CsvException;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class NotebookServiceTest extends TestCase {




    public void testGetByBrand() throws IOException, CsvException {
        ReadProductFromcCSV readFromCSV = new ReadProductFromcCSV();
        NotebookServiceImpl noteBookSvc = new NotebookServiceImpl(readFromCSV.readProductFromSCV());
        List<NoteBook> noteBooks = noteBookSvc.getByBrand("ASUS");

        assertEquals(2,noteBooks.size());
    }
}