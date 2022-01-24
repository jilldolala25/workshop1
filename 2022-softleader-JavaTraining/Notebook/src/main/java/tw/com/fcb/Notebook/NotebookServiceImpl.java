package tw.com.fcb.Notebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotebookServiceImpl implements NotebookService {

	Map<String, NoteBook> myNotebook = new HashMap<String, NoteBook>();

	public NotebookServiceImpl(Map<String, NoteBook> myNotebook) {
		this.myNotebook = myNotebook;
	}

	public NotebookServiceImpl(NotebookServiceImpl noteBookSvc) {

	}


	@Override
	public String toString() {
		return "NotebookServiceImpl [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}



	public void getAllProduct() {
		for (String key : myNotebook.keySet()) {
			NoteBook content = myNotebook.get(key);
			System.out.println("data = " + content);

		}
//		System.out.println("myNotebook = " + myNotebook);
	}



	@Override
	public List<NoteBook> getByBrand(String brand) {
		List<NoteBook> brandResult = new ArrayList<NoteBook>();

		for (String key : myNotebook.keySet()) {
			NoteBook thisBrand = myNotebook.get(key);

			int count = -1;
			if (thisBrand.getBrand().equals(brand)) {
				count ++;
				brandResult.add(thisBrand);

			} else {
				if (count == 0) {
					System.out.println("No Result Found !");
				}
			}
		}
		return brandResult;
	}

	@Override
	public List<NoteBook> getByCPU(String cpu) {
		List<NoteBook> cpuResult = new ArrayList<NoteBook>();

		for (String key : myNotebook.keySet()) {
			NoteBook thisCPU = myNotebook.get(key);

			int count = -1;
			if (thisCPU.getCpu().equals(cpu)) {
				count ++;
				cpuResult.add(thisCPU);

			} else {
				if (count == 0) {
					System.out.println("No Result Found !");
				}
			}
		}
		return cpuResult;
	}

	@Override
	public List<NoteBook> getByColor(String color) {
		List<NoteBook> colorResult = new ArrayList<NoteBook>();

		for (String key:myNotebook.keySet()) {
			NoteBook thisColor = myNotebook.get(key);
			int count = -1;
			if (thisColor.getColor().equals(color)) {
				count ++;
				colorResult.add(thisColor);

			} else {
				if (count == 0) {
					System.out.println("No Result Found !");
				}
			}
		}
		return colorResult;
	}

	public List<NoteBook> getByScreenSize(String screenSize) {
		List<NoteBook> screenSizeResult = new ArrayList<NoteBook>();

		for (String key:myNotebook.keySet()) {
			NoteBook thisScreenSize = myNotebook.get(key);
			int count = -1;
			if (thisScreenSize.getScreenSize().equals(screenSize)) {
				count ++;
				screenSizeResult.add(thisScreenSize);

			} else {
				if (count == 0) {
					System.out.println("No Result Found !");
				}
			}
		}
		return screenSizeResult;
	}

	@Override
	public void getAllproduct() {
		for (String key : myNotebook.keySet()) {
			NoteBook content = myNotebook.get(key);
			System.out.println("data1 = " + content);

		}
	}
}