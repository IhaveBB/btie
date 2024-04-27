public class User {
	private String name;
	private String pwString;
	public User(String name, String pwString) {
		super();
		this.name = name;
		this.pwString = pwString;
	}
	public String getName() {
		return name;
	}
	//设置修改器和设置器
	public void setName(String name) {
		this.name = name;
	}
	public String getPwString() {
		return pwString;
	}
	public void setPwString(String pwString) {
		this.pwString = pwString;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", pwString='" + pwString + '\'' +
				'}';
	}
}