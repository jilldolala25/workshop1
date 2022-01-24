package tw.com.fcb.Notebook;


import java.io.IOException;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class NotebookApp {
	
	public static void main(String[] args) throws IOException, CsvException {

		ReadProductFromcCSV readFromCSV = new ReadProductFromcCSV();
		NotebookServiceImpl noteBookSvc = new NotebookServiceImpl(readFromCSV.readProductFromSCV());
		noteBookSvc.getAllProduct();
		List<NoteBook> result = null;

		boolean entrychoose = false;
		System.out.println("請輸入搜尋類別：1:品牌 2:CPU 3:顏色 4:螢幕尺吋 ");
		Scanner scanner = new Scanner(System.in);
		var option = scanner.next().toString();
		if (option.equals("1")|| option.equals("2") || option.equals("3") || option.equals("4")){
			entrychoose = true;
		}
		while(entrychoose)  {
			switch (option){
				case "1":
					System.out.println("請輸入欲查詢之品牌 : ");
					Scanner scanner1 = new Scanner(System.in);
					String inputBrand = scanner1.next();
					result = noteBookSvc.getByBrand(inputBrand.toUpperCase().toString());
					System.out.println("你所輸入的品牌 "+ inputBrand.toString()+" 共有"+ result.size()+ "項商品" );
					result.forEach(System.out::println);
					break;
				case "2":

					System.out.println("請輸入欲查詢CPU等級 (i5,i7,M1) : ");
					scanner1 = new Scanner(System.in);
					String inputCPU = scanner1.next();
					result = noteBookSvc.getByCPU(inputCPU.toString());
					System.out.println("你所輸入的cpu等級 "+ inputCPU.toString()+" 共有"+ result.size()+ "項商品" );
					result.forEach(System.out::println);
					break;
				case "3":

					System.out.println("請輸入欲查詢顏色 (BLACK,WHITE...) : ");
					scanner1 = new Scanner(System.in);
					String inputColor = scanner1.next();
					result = noteBookSvc.getByColor(inputColor.toUpperCase().toString());
					System.out.println("你所輸入的顏色 "+ inputColor.toString()+" 共有"+ result.size()+ "項商品" );
					result.forEach(System.out::println);
					break;
				case "4":

					System.out.println("請輸入欲查詢螢幕尺吋 (13,15.6,16...) : ");
					scanner1 = new Scanner(System.in);
					String inputScreenSize = scanner1.next();
					result = noteBookSvc.getByScreenSize(inputScreenSize.toUpperCase().toString());
					System.out.println("你所輸入的螢幕尺吋 "+ inputScreenSize.toString()+" 共有"+ result.size()+ "項商品" );
					result.forEach(System.out::println);
					break;
				default:
					System.out.println("輸入錯誤!");
					break;
			}

			if ((!result.isEmpty())) break;
		}

}
}

