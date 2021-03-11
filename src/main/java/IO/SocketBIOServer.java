package IO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketBIOServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(3333);
    new Thread(() -> {
      while (true) {
        try {
          Socket socket = serverSocket.accept();//阻塞
          new Thread(() -> {
            try {
              int len;
              byte[] data = new byte[1024];
              InputStream inputStream = socket.getInputStream();
              while ((len = inputStream.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
              }
            } catch (IOException e) {
            }
          }).start();

        } catch (IOException e) {
        }

      }
    }).start();

  }

}

//BIO