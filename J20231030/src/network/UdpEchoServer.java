package network;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UdpEchoServer {
    //创建一个DatagramSocket对象, 用于后续操作网卡
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        //给服务器手动指定端口号
        socket = new DatagramSocket(port);
        //让系统自动给服务器指定端口号
        //socket = new DatagramSocket();
    }

    //这个方法用于启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动!");
        //一个服务器程序中, 经常能看到while(true)这样的代码
        while (true) {
            //1.读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //当前完成receive之后, 数据是以二进制的形式存储到DatagramPacket中了
            //要想把这里的数据显示出来, 还需要把这个二进制数据给转成字符串
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //2.根据请求计算响应(一般的服务器都会经历的过程)
            //由于此处是回显服务器, 请求是什么,响应就是什么
            String response = process(request);
            //3.把响应写回到客户端
            //搞一个响应对象, DatagramPacket
            //往DatagramPacket里构造刚才的数据, 再通过send返回
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //打印一个日志, 把这次的数据交互的详情给打印出来
            System.out.printf("[%s:%d] req=%s, resp=%s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
