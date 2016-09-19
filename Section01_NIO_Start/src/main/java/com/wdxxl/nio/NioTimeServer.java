package com.wdxxl.nio;

public class NioTimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        NioMultiplexerTimeServer timeServer = new NioMultiplexerTimeServer(port);
        new Thread(timeServer, "Nio-MultiplexerTimeServer-001").start();
    }

}
