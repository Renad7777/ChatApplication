  import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
private static ChatClient instance; // المتغير الثابت الخاص بالمثيل الوحيد
    private Socket clientSocket;
    private PrintWriter outputToServer;
    private Scanner inputFromServer;
    
    // Constructor خاص لمنع إنشاء مثيل مباشر من الفئة
    private ChatClient() {}

    // الطريقة العامة للحصول على المثيل الوحيد
    public static ChatClient getInstance() {
        if (instance == null) {
            synchronized (ChatClient.class) { // إضافة المزامنة للتأكد من الأمان في بيئة متعددة الخيوط
                if (instance == null) {
                    instance = new ChatClient();
                }
            }
        }
        return instance;
    }

    // تهيئة الاتصال بالخادم
    public void startConnection(String host, int port) throws IOException {
        clientSocket = new Socket(host, port);
        outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
        inputFromServer = new Scanner(clientSocket.getInputStream());
        System.out.println("Connection established.");
    }

    // إرسال رسالة للخادم
    public void sendMessage(String message) {
        outputToServer.println(message);
    }

    // استقبال رسالة من الخادم
    public String receiveMessage() {
        return inputFromServer.nextLine();
    }

    // إغلاق الاتصال
    public void closeConnection() throws IOException {
        if (clientSocket != null && !clientSocket.isClosed()) {
            clientSocket.close();
        }
    }

    public static void main(String[] args) {
        try {
              Ports e = PortsFactory.creatPorts(PortsFactory.port2);
        System.out.println(e);
        Port2 t = new Port2();
            ChatClient client = ChatClient.getInstance(); // الحصول على المثيل الوحيد
            client.startConnection("localhost", t.getPort2());

            Scanner inputFromUser = new Scanner(System.in);
            String message;
            
            while (true) {
                System.out.print("Client: ");
                message = inputFromUser.nextLine();
                
                client.sendMessage(message);
                if (message.equals("**close**")) {
                    break;
                }
                
                String inFromServer = client.receiveMessage();
                System.out.println("Server: " + inFromServer);
            }
            client.closeConnection();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }}
