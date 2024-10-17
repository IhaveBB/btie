/**
 * @name: Single
 * @author: IhaveBB
 * @date: 2024-10-17 19:16
 **/
public class LiuJunBao {
	private static int count;
	private String name;
	private static LiuJunBao instance;
	public void show(){
		System.out.println("name:"+name);
		System.out.println("count:"+count);
	}
	private LiuJunBao(String name){
		this.name = name;
	}
	public static LiuJunBao getInstance(String name){
		if(instance == null){
			instance = new LiuJunBao(name);
		}else{
			instance.setName(name);
		}
		count++;
		return instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
