
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    private static ChatServer instance; // المتغير الثابت للمثيل الوحيد
    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private PrintWriter outFromServer;
    private Scanner inFromClient;

    // منشئ خاص لمنع الإنشاء المباشر
    private ChatServer() {}

    // الطريقة العامة للحصول على المثيل الوحيد
    public static ChatServer getInstance() {
        if (instance == null) {
            synchronized (ChatServer.class) { // تأمين في حالة تعدد الخيوط
                if (instance == null) {
                    instance = new ChatServer();
                }
            }
        }
        return instance;
    }

    // بدء تشغيل الخادم
    public void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running and waiting for client...");
        connectionSocket = serverSocket.accept();
        System.out.println("Client connected.");
        outFromServer = new PrintWriter(connectionSocket.getOutputStream(), true);
        inFromClient = new Scanner(connectionSocket.getInputStream());
    }

    // استقبال رسالة من العميل
    public String receiveMessage() {
        return inFromClient.nextLine();
    }

    // إرسال رسالة إلى العميل
    public void sendMessage(String message) {
        outFromServer.println(message);
    }

    // إغلاق الاتصال
    public void stopServer() throws IOException {
        if (connectionSocket != null && !connectionSocket.isClosed()) {
            connectionSocket.close();
        }
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
        System.out.println("Server stopped.");
    }

    public static void main(String[] args) {
        try {
            ChatServer server = ChatServer.getInstance(); // الحصول على المثيل الوحيد
            server.startServer(6789);

            Scanner inFromServer = new Scanner(System.in);
            String input, output;

            while (true) {
                input = server.receiveMessage();
                System.out.println("Client: " + input);

                if (input.equals("**close**")) {
                    break;
                }

                System.out.print("Server: ");
                output = inFromServer.nextLine();
                server.sendMessage(output);
            }
            server.stopServer();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}