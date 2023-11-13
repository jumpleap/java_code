package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoServer {
    private ServerSocket socket = null;

    public TcpEchoServer(int port) throws IOException {
        // 指定一个固定的端口号
        socket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");

        while (true) {
            // 建立连接, 把内核中已经建立好连接的客户端拿到
            Socket clientSocket = socket.accept();
            processConnection(clientSocket);
        }
    }

    // 处理过程
    public void processConnection(Socket clientSocket) {
        // 打印日志, 表示有客户端连接上了
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress(),
                clientSocket.getPort());

        //使用字节流进行操作
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            while (true) {
                // 读取客户端发来的请求
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    // 连接断开, 循环就应该结束
                    System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress(),
                            clientSocket.getPort());
                    break;
                }

                // 1.读取请求并解析, "\n作为结束标志"
                String request = scanner.next();

                // 2.根据请求计算响应
                String response = process(request);

                // 3.把响应写回到客户端中
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                // 刷新缓冲区
                printWriter.flush();

                // 4.打印本次交互的日志
                System.out.printf("[%s:%d] req=%s resp=%s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭clientSocket资源
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}