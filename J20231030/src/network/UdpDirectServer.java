package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDirectServer extends UdpEchoServer {
    private Map<String, String> words = new HashMap<>();

    //使用父类的构造器
    public UdpDirectServer(int port) throws SocketException {
        super(port);

        words.put("dog", "小狗");
        words.put("cat", "小猫");
        words.put("pig", "小猪");
    }

    @Override
    public String process(String request) {
        return words.getOrDefault(request, "这个词汇不存在!");
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpDirectServer(9090);
        udpEchoServer.start();
    }
}
