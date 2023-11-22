package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket;

    // 客户端自动分配自己的端口号, 但是要指定要访问的服务器
    public TcpEchoClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    // 用这个方法来启动客户端
    public void start() {
        System.out.println("客户端启动!");

        Scanner scanner = new Scanner(System.in);
        // 使用InputStream和OutputStream用于数据的交互
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            PrintWriter printWriter = new PrintWriter(outputStream);
            Scanner scan = new Scanner(inputStream);

            while (true) {
                // 1. 从控制台读取数据构造请求
                System.out.print("-> ");
                String request = scanner.next();

                // 2.把请求发送给服务器
                printWriter.println(request);
                printWriter.flush();

                // 3.读取服务器返回的响应
                String response = scan.next();

                // 4.打印出响应的内容
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // main 启动客户端
    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
