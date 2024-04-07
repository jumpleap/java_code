package ee_basic.network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

// 查词服务器
public class UdpDirectServer extends UdpEchoServer {
    // 建立单词和含义之间的映射
    private final Map<String, String> director = new HashMap<>();

    /**
     * 需要给服务器端指定端口号, 防止端口冲突
     * @throws SocketException
     */
    public UdpDirectServer(int port) throws SocketException {
        super(port);
        // director中放入几个单词及其含义
        add();
    }

    /**
     * 在map中放入几个单词
     */
    private void add() {
        director.put("cat", "小猫");
        director.put("hammer", "锤子");
        director.put("attic", "阁楼");
        director.put("campus", "校园");
    }

    @Override
    public String process(String request) {
        return director.getOrDefault(request, "该词不存在!");
    }

    public static void main(String[] args) throws IOException {
        // 启动服务器
        UdpDirectServer server = new UdpDirectServer(9090);
        server.start();
    }
}
