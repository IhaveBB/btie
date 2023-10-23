package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
	private Socket socket = null;

	public TcpEchoClient(String serverIp,int ServerPort) throws IOException {
		// 需要在创建 Socket 的同时, 和服务器 "建立连接", 此时就得告诉 Socket 服务器在哪里~~
		// 具体建立连接的细节, 不需要咱们代码手动干预. 是内核自动负责的.
		// 当我们 new 这个对象的时候, 操作系统内核, 就开始进行 三次握手 具体细节, 完成建立连接的过程了.
		socket = new Socket(serverIp,ServerPort);
	}
	public void start(){
		Scanner sc = new Scanner(System.in);
		try(InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream()) {
			PrintWriter writer = new PrintWriter(outputStream);
			Scanner scannerNetWork = new Scanner(inputStream);
			while(true){
				//1.从控制台读取用户输入的内容
				System.out.println("->");
				String request = sc.next();
				// 2. 把字符串作为请求, 发送给服务器
				//    这里使用 println, 是为了让请求后面带上换行.
				//    也就是和服务器读取请求, scanner.next 呼应
				writer.println(request);
				writer.flush();
				//3.读取服务器返回的相应
				String response = scannerNetWork.next();
				//4.输出内容
				System.out.println(response);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		TcpEchoClient tcpEchoClient = new TcpEchoClient("10.219.94.164",9090);
		tcpEchoClient.start();
	}

}