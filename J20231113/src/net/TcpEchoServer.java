package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket socket;
    private int port;

    // 需要手动指定一个端口号, 防止冲突
    public TcpEchoServer(int port) throws IOException {
        socket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        // 线程池
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            // 建立连接, 把内核中已经建立好连接的客户端拿到
            Socket clientSocket = socket.accept();

            // 每进来一个客户端, 那么就为这个客户端分配一个线程来执行任务
            service.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    public void processConnection(Socket clientSocket) {

        // 打印日志, 表示有客户端连上了
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress(),
                clientSocket.getPort());

        // inputStream用于获取客户端发来的响应, outputStream用于发送请求给客户端
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            while (true) {
                // 读取客户端发来请求
                Scanner scanner = new Scanner(inputStream);

                if (!scanner.hasNext()) {
                    // 没有后续的请求了, 连接断开
                    System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress(),
                            clientSocket.getPort());
                    break;
                }

                // 1. 读取请求并解析
                String request = scanner.next();

                // 2.根据请求计算响应
                String response = process(request);

                // 3.把响应写回到客户端中
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                // 刷新缓冲区, 防止发送的数据没有写入到内存缓冲区中
                printWriter.flush();

                // 4.打印本次交互的日志
                System.out.printf("[%s:%d] req=%s, resp=%s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
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
