package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String severIp = "";
    private int severPort = 0;
    public UdpEchoClient(String severIp,int severPort) throws SocketException {
        //创建这个对象不能手动指定端口
        socket = new DatagramSocket();
        //由于UDP自身不回持有对端的信息，就需要在应用程序中把对端的情况记录下来。
        this.severIp = severIp;
        this.severPort = severPort;
    }

    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner sc = new Scanner(System.in);
        while(true){
            //1.从控制台读取一个数据,作为请求
            System.out.print("->");
            String request = sc.next();
            //2.把请求内容构造成一个DatagramPacket对象，发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length, InetAddress.getByName((severIp)), severPort);
            socket.send(requestPacket);
            //3.尝试读取服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            //4.把响应转换成字符串，并打印输出
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }
}
