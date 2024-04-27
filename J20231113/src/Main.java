
class CustObject{
	int val;
	public CustObject(int val){
		this.val = val;
	}
}

public class Main {
	public static void main(String[] args) {
		CustObject obj = new CustObject(1);
		modfifyObject(obj);
		System.out.println("调用后"+obj.val);
	}
	public static void modfifyObject(CustObject custObject){
		custObject.val = 2;
		System.out.println("调用时"+custObject.val);
	}


}
