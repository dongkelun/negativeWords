package zx.soft.words.model;

public class Words {

	private int id;
	private int cate_id;
	private String name;
	private int degree;

	public Words() {
		super();
	}

	public Words(int id, int cate_id, String name, int degree) {
		super();
		this.id = id;
		this.cate_id = cate_id;
		this.name = name;
		this.degree = degree;
	}

	public Words(int cate_id, String name, int degree) {
		super();
		this.cate_id = cate_id;
		this.name = name;
		this.degree = degree;
	}

	public Words(int cate_id, String name) {
		super();
		this.cate_id = cate_id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Words [id=" + id + ", cate_id=" + cate_id + ", name=" + name
				+ ", degree=" + degree + "]";
	}

}
