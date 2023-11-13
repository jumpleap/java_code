package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// Udp服务器
public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        // 给服务器指定端口, 若是自动分配端防止端口冲突
        socket = new DatagramSocket(port);
    }

    // 使用这个方法来启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动!");

        while (true) {
            // 1.读取客户端发来的请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket); // 读取客户端发来的请求
            // 把二进制的数据转化为字符串
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            // 2.根据请求计算响应
            String response = process(request);

            // 3.把响应返回到客户端中
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());

            socket.send(responsePacket);

            // 在服务器中打印此次交互的日志
            System.out.printf("[%s:%d] req=%s resp=%s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}