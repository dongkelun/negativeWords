package zx.soft.words.model;

public class Categories {

	private int cate_id;
	private String name;
	private String type;
	
	 
	public Categories() {
		super();
	}

	public Categories(int cate_id, String name, String type) {
		super();
		this.cate_id = cate_id;
		this.name = name;
		this.type = type;
	}
	
	public Categories(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Categories [cate_id=" + cate_id + ", name=" + name + ", type=" + type + "]";
	}

	
}
