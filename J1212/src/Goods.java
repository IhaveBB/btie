public class Goods {
	private String kind;//商品种类
	private String gname;//商品名称
	private String price;//商品价格
	public Goods(String kind, String gname, String price) {
		super();
		this.kind = kind;
		this.gname = gname;
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}





}