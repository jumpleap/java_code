package network;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TcpDirectServer extends TcpEchoServer {
    // 构造单词和含义之间的联系
    private Map<String, String> director = new HashMap<>();

    public TcpDirectServer(int port) throws IOException {
        super(port);
        addWords();
    }

    private void addWords() {
        director.put("school", "校园");
        director.put("pig", "猪");
        director.put("milk", "牛奶");
        director.put("tea", "茶");
    }

    @Override
    public String process(String request) {
        return director.getOrDefault(request, "没有该单词!");
    }

    public static void main(String[] args) throws IOException {
        TcpDirectServer server = new TcpDirectServer(9090);
        server.start();
    }
}
