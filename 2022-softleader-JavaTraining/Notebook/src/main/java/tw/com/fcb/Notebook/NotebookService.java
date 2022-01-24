package tw.com.fcb.Notebook;

import java.util.List;

public interface NotebookService {


	public List<NoteBook> getByBrand(String brand);

	public List<NoteBook> getByCPU(String cpu);

	public List<NoteBook> getByColor(String color);

	public List<NoteBook> getByScreenSize(String screenSize);

	public void getAllproduct();
}
