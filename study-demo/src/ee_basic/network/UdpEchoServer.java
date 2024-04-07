package ee_basic.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// Udp服务器端代码
public class UdpEchoServer {
    // 创建一个 DatagramSocket 对象, 后续操作网卡的基础
    private DatagramSocket socket;

    /**
     * 需要给服务器端指定端口号, 防止端口冲突
     *
     * @throws SocketException
     */
    public UdpEchoServer(int port) throws SocketException {
        // 手动指定端口, 防止端口冲突
        socket = new DatagramSocket(port);
        // 这样做就是让系统自动分配端口
        // socket = new DatagramSocket();
    }


    /**
     * 使用这个方法来启动服务器
     */
    public void start() throws IOException {
        System.out.println("服务器启动!");

        // 一个服务器程序中, 经常能看到while true这样的代码
        while (true) {
            // 1.读取请求并解析
            // DatagramPacket用于获取客户端发来的数据
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            // 当完成receive后, 数据是以二进制的形式存储到DatagramPacket中
            // 要想把这里的数据给显示出来, 还需要把二进制的数据转化字符串
            // requestPacket.getData(): 读取requestPacket中的二进制数据, 从0开始读取, 读到末尾
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            // 2.根据请求计算响应(一般的服务器都会经历的过程,此处是回显服务器)
            String response = process(request);

            // 3.把响应写回到客户端, responsePacket: 响应对象
            // response.getBytes(): 把response字符串转化为二进制数组
            // response.getBytes().length: 二进制数组的长度
            // requestPacket.getSocketAddress(): 获取客户端的地址, 并把响应传过去
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            // 返回响应给客户端
            socket.send(responsePacket);

            // 4.打印日志, 把这次数据交互的详情显示出来
            System.out.printf("[%s:%d] req=%s, resp=%s\n", requestPacket.getAddress().toString(),
                    responsePacket.getPort(), request, response);
        }
    }

    // 根据请求计算响应的过程
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        // 创建服务器并给服务器指定端口号
        UdpEchoServer server = new UdpEchoServer(9090);
        // 启动服务器
        server.start();
    }
}