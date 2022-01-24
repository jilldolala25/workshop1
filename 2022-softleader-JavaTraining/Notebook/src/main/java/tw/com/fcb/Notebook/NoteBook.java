package tw.com.fcb.Notebook;

public class NoteBook {
	private String productNo;
	private String brand;
	private String screenSize;
	private String cpu;
	private String memory;
	private String storage;
	private String color;
	private int price;

	@Override
	public String toString() {
		return "NoteBook{" +
				"productNo='" + productNo + '\'' +
				", brand='" + brand + '\'' +
				", screenSize='" + screenSize + '\'' +
				", cpu='" + cpu + '\'' +
				", memory='" + memory + '\'' +
				", storage='" + storage + '\'' +
				", color='" + color + '\'' +
				", price=" + price +
				'}';
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCpu() {return cpu;	}

	public void setCpu(String cpu) {this.cpu = cpu;	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
