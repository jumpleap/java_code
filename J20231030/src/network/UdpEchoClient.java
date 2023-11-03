package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket;
    private String serverIp; //服务器ip
    private int port; //服务器的端口号

    public UdpEchoClient(String ip, int port) throws SocketException {
        //创建这个对象, 不能手动指定端口号
        socket = new DatagramSocket();
        //由于UDP自身不会持有对端信息, 就需要在应用程序里, 把对端的情况给记录下来
        //这里主要记录对端的IP和端口号
        this.serverIp = ip;
        this.port = port;
    }

    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //1.从控制台读取数据,作为请求
            System.out.print("->");
            String request = scanner.next();
            //2.把请求内容构造成DatagramPacket对象, 发给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), port);
            socket.send(requestPacket);
            //3.尝试读取服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            //4.把响应转化为字符串, 打印出来
            String response = new String(responsePacket.getData(), 0,
                    responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
