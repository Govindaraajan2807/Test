package entity;

public class Watch {
	private int id;
	private String modelNumber;
	private float price;
	private int typeId;

	public Watch() {
		super();
	}

	public Watch(int id, String modelNumber, float price, int typeId) {
		super();
		this.id = id;
		this.modelNumber = modelNumber;
		this.price = price;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}
