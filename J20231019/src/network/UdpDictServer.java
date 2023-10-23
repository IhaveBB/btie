package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer {
	private Map<String, String> dict = new HashMap<>();

	public UdpDictServer(int port) throws SocketException {
		super(port);
		dict.put("dog", "小狗");
		dict.put("cat", "小猫");
	}

	@Override
	public String process(String request) {
		return dict.get(request);
	}

	public static void main(String[] args) throws IOException {
		UdpDictServer server = new UdpDictServer(9090);
		server.start();
	}
}
