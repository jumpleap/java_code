package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String ip, int port) throws IOException {
        // 告诉客户端应该把数据发送到那个地方, 即ip和端口
        socket = new Socket(ip, port);
    }

    public void start() {
        System.out.println("客户端启动");

        Scanner scanner = new Scanner(System.in);

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            PrintWriter printWriter = new PrintWriter(outputStream);
            Scanner scannerNext = new Scanner(inputStream);
            while (true) {
                // 1.构造请求
                System.out.print("-> ");
                String request = scanner.next();

                // 2.发送请求
                printWriter.println(request);
                // 刷新缓冲区
                printWriter.flush();


                // 3.读取服务器发来的响应
                String response = scannerNext.next();

                // 4.打印本次交互的数据
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
