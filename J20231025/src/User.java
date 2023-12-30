public class User {
	private String name;//用户名
	private String password;//用户密码
	public User(String name,String password) {

		this.name=name;
		this.password=password;
	}
	//设置器和修改器(允许类在状态被访问或改变时执行操作)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

}