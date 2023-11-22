package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TcpEchoServer {
    private ServerSocket socket;

    // 需要给服务器指定端口号
    public TcpEchoServer(int port) throws IOException {
        socket = new ServerSocket(port);
    }

    // 使用该方法启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动!");
        // 创建线程池
        ExecutorService service = Executors.newCachedThreadPool();

        while (true) {
            // 在内核中建立连接
            Socket clientSocket = socket.accept();

            // 拿到的客户端进行操作
            service.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) {

        // 打印出客户端信息
        System.out.printf("[%s:%d] 客户端上线!\n",
                clientSocket.getInetAddress(), clientSocket.getPort());

        // 服务器和客户端进行数据交互
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            // Scanner用于读取客户端发来的请求
            Scanner scanner = new Scanner(inputStream);
            // PrintWriter 用于发送服务器构造的响应
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                if (!scanner.hasNext()) {
                    // 已经读完, 当前客户端退出
                    System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress(),
                            clientSocket.getPort());
                    break;
                }

                // 1. 读取客户端发来的请求
                String request = scanner.next();

                // 2.根据请求构造响应
                String response = process(request);

                // 3.把响应返回到客户端中
                printWriter.println(response);
                printWriter.flush();

                // 4.打印本次交互的数据
                System.out.printf("[%s:%d] req=%s, resp=%s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    // main方法启动服务器
    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}