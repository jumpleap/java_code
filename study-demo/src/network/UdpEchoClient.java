package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

// Udp客户端代码
public class UdpEchoClient {
    // 创建一个DatagramSocket的对象, 后续操作网卡的基础
    private DatagramSocket socket;
    private String ip; // 服务器IP
    private Integer port; // 服务器的端口

    /**
     * 需要给客户端指定要访问的服务器IP和端口号
     *
     * @throws SocketException
     */
    public UdpEchoClient(String ip, int port) throws SocketException {
        // 客户端的端口号不需要指定, 防止客户端冲突
        socket = new DatagramSocket();
        // 指定服务器的地址和端口, 由于Udp自身不会保存对端的信息, 就需要在应用程序里把对端的情况记录下来
        this.ip = ip;
        this.port = port;
    }

    /**
     * 这个方法用于启动客户端
     */
    public void start() throws IOException {
        System.out.println("客户端启动!");

        // 一个服务器程序中, 经常能看到while true这样的代码
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1.从控制台读取数据, 作为请求
            System.out.println("-> ");
            String request = scanner.next();

            // 2.把请求内容构造成 DatagramPacket 对象, 发给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(ip), port);
            socket.send(requestPacket);

            // 3.读取从服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);

            // 4.把读到的响应转化为字符串, 并打印
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
