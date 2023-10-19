package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //创建一个DatagramScocket对象
    //这是后续操作网卡的基础
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        /*
        我们在服务器和客户端中均需要创建一个Socket对象
        但是服务器的socket一般需要显示的指定一个端口号
        而客户端的socket一般不能显示指定（不显示指定时候系统会自动分配一个随机的端口）
         */
    }

    //通过这个方法开启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){
            //我们在使用socket.receive来接受数据时，需要先创建一个数据报（DatagramPacket)用来接受从网卡读取到的数据，
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            //1.读取请求并解析
            socket.receive(requestPacket);
            //当前完成recive之后，数据以二进制的形式存储到DatagramPacket中
            //要想能够把数据显示出来，还需要把二进制转成字符串
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());
            //2.由于我们此处是回显服务器，所以请求=响应。
            String reponse = process(request);
            //3.把响应写回客户端
            //  搞一个响应对象，DatagramPacket
            //  往DatagramPacket中填入刚才的数据，在通过sent返回
            //传入数据报,数据报长度，和请求中的地址
            DatagramPacket reponsePacket = new DatagramPacket(reponse.getBytes(),reponse.getBytes().length,requestPacket.getSocketAddress());
            //注意这个长度不可以更改成reponse.length，因为如果这个字符串的内容都是英文字符，此时字节和字符个数是一样的，但是如果包含中文就不一样了。
            socket.send(reponsePacket);
            //4.打印日志
            System.out.printf("[%s:%d] req=%s res=%s\n",reponsePacket.getAddress().toString(),reponsePacket.getPort(),request,reponse);

        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {

        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }
}
