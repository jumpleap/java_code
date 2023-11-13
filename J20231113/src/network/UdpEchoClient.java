package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp = "";
    private int port = 0;

    public UdpEchoClient(String ip, int port) throws SocketException {
        // 客户端让系统自动分配端口号, 防止重复使用
        socket = new DatagramSocket();
        // 指定服务器的ip和端口号, 后续发送数据的时候使用
        this.serverIp = ip;
        this.port = port;
    }

    // 使用这个方法来启动客户端
    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1.从控制台构造请求
            System.out.print("-> ");
            String request = scanner.next();

            // 2.构造请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), port);
            socket.send(requestPacket);

            // 3.获取服务器发来的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);

            // 4.把获取的响应数据打印出来
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}