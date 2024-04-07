package ee_basic.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Tcp服务器代码
public class TcpEchoServer {
    // 创建 ServerSocket 对象, 用于和客户端进行通信
    private ServerSocket socket;

    // 需要给服务器指定端口号, 若自定分配会导致端口冲突
    public TcpEchoServer(int port) throws IOException {
        socket = new ServerSocket(port);
    }

    // 这个方法用于启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动!");
        // 创建线程池
        ExecutorService service = Executors.newCachedThreadPool();

        // 在服务器代码中会常见到 while(true)这样的代码
        while (true) {
            // 通过 accept 方法, 把内核中已经建立好的连接拿到应用程序中
            // 建立连接的细节流程都是内核自动完成的, 应用程序只需要直接拿建立号的客户端即可
            Socket clientSocket = socket.accept();

            // 这个方法不够好, 线程的创建销毁多了, 太重量
            // 使用多线程的方式, 让多个客户端同时进行访问
            /*
            Thread ee_basic.thread = new Thread(() -> {
                // 连接处理
                processConnection(clientSocket);
            });
            ee_basic.thread.start();
            */

            // 更好的方法, 使用线程池
            service.submit(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    // 通过这个方法, 来处理当前的连接
    public void processConnection(Socket clientSocket) {
        // 进入方法, 先打印一个日志, 表示当前有客户端连接上了
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress(), clientSocket.getPort());

        // 接下来进行数据交互
        // try的目的: 避免后续用完了流对象, 忘记关闭
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            // 由于客户端发来的数据可能是多条数据, 针对多条数据, 进行循环的处理
            while (true) {
                // 从输入流中读取内容
                Scanner scanner = new Scanner(inputStream);
                // 当读不到数据的时候, 就断开连接了
                if (!scanner.hasNext()) {
                    // 连接断开, 循环就需要结束
                    System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress(), clientSocket.getPort());
                    break;
                }

                // 1.读取请求并解析, 此处使用 next 的方式来读取请求的方式, next 的规则是: 读到"空白符"就返回
                String request = scanner.next();

                // 2.根据请求, 计算响应
                String response = process(request);

                // 3.把响应写回到客户端
                // 这里也可以把 String 转成字节数组, 写入到 outputStream中
                // 这里使用的是 PrintWriter 把outputStream 包裹一下, 来写入字符串
                PrintWriter printWriter = new PrintWriter(outputStream);
                // 此处的 println 不是打印了, 而是写入到 outputStream 对应的流对象中, 也就是写入到 clientSocket 中
                // 自然这个数据也就通过网络发送出去了(发给当前这个连接的另外一端)
                // 此处的 println 带有 \n 也就是为了 后续客户端这边可以使用 scanner.next 来读取数据
                printWriter.println(response);
                // 刷新缓冲区, 防止数据没有被写入网卡, 还在内存中
                printWriter.flush();

                // 4.打印此次交互的数据
                System.out.printf("[%s:%d] req=%s, resp=%s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 对clientSocket的关闭
                // processConnection 是在处理一个连接, 这个方法执行完毕, 这个连接也就处理完了
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 根据请求计算响应
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
