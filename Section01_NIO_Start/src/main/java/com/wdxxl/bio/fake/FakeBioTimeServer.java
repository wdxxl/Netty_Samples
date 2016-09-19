package com.wdxxl.bio.fake;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FakeBioTimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        try (ServerSocket server = new ServerSocket(port);) {
            System.out.println("The Time Server is start in port: " + port);
            Socket socket = null;
            //创建 I/O 任务线程池
            FakeBioTimeServerHandlerExecutePool singleExecutor = new FakeBioTimeServerHandlerExecutePool(50, 1000);
            while (true) {
                socket = server.accept();
                singleExecutor.execute(new FakeBioTimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("The Time Server close.");
        }
    }

}
