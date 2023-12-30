public class Books {
	private String kind;//书的类型
	private String name;//书的名称
	private String code;//书的编码
	public Books(String kind,String name,String code) {
		this.kind=kind;
		this.name=name;
		this.code=code;
	}
	//设置器和修改器(允许类在状态被访问或改变时执行操作)
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Books [kind=" + kind + ", name=" + name + ", code=" + code + "]";
	}


}

