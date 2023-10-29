package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
	private ServerSocket severSocket = null;
	public TcpEchoServer(int port) throws IOException {
		severSocket = new ServerSocket(port);
	}
	public void start() throws IOException {
		System.out.println("服务器启动");
		ExecutorService service = Executors.newCachedThreadPool();
		while(true){
			//通过accetp方法，把内核中已经建立 好的链接拿到应用中
			//建立连接的细节流程是内核自动完成的，应用程序只需要捡现成的即可
			Socket clientSocket = severSocket.accept();

			service.submit(new Runnable(){
				@Override
				public void run(){
					processConnection(clientSocket);
				}
			});
		}
	}

	//通过这个方法来处理当前的连接
	public void processConnection(Socket clientSocket){
		//进入方法，打印出一个日志，表示当前有客户端连接上了
		System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress(), clientSocket.getPort());
		try(InputStream inputStream = clientSocket.getInputStream();
			OutputStream outputStream = clientSocket.getOutputStream()) {
			// 使用 try ( ) 方式, 避免后续用完了流对象, 忘记关闭.
			// 由于客户端发来的数据, 可能是 "多条数据", 针对多条数据, 就循环的处理.
			while(true){
				Scanner sc = new Scanner(inputStream);
				if(!sc.hasNext()){
					// 连接断开了. 此时循环就应该结束
					System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress(), clientSocket.getPort());
					break;
				}
				// 1. 读取请求并解析. 此处就以 next 来作为读取请求的方式. next 的规则是, 读到 "空白符" 就返回.
				String request = sc.next();
				// 2. 根据请求, 计算响应.
				String response = processs(request);
				// 3. 把响应写回到客户端.
				//    可以把 String 转成字节数组, 写入到 OutputStream
				//    也可以使用 PrintWriter 把 OutputStream 包裹一下, 来写入字符串.
				PrintWriter printWriter = new PrintWriter(outputStream);
				//    此处的 println 不是打印到控制台了, 而是写入到 outputStream 对应的流对象中, 也就是写入到 clientSocket 里面.
				//    自然这个数据也就通过网络发送出去了. (发给当前这个连接的另外一端)
				//    此处使用 println 带有 \n 也是为了后续 客户端这边 可以使用 scanner.next 来读取数据.
				printWriter.println(response);
				//    此处还要记得有个操作, 刷新缓冲区. 如果没有刷新操作, 可能数据仍然是在内存中, 没有被写入网卡.
				printWriter.flush();
				// 4. 打印一下这次请求交互过程的内容
				System.out.printf("[%s:%d] req=%s, resp=%s\n", clientSocket.getInetAddress(), clientSocket.getPort(), request, response);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally{
			try {
				// 在这个地方, 进行 clientSocket 的关闭.
				// processConnection 就是在处理一个连接. 这个方法执行完毕, 这个连接也就处理完了.
				clientSocket.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public String processs(String request){
		return request;
	}

	public static void main(String[] args) throws IOException {
		TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
		tcpEchoServer.start();
	}
}
