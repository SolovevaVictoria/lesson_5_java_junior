package example2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer() { // метод запуска сокета
        try {
            while (!serverSocket.isClosed()) { // блокируем приложение в ожидании запроса на подключение
                Socket socket = serverSocket.accept(); // как только получаем запрос, формируется канал связи
                // и объект Socket сохраняется вся информация о только что созданном подключении
                System.out.println("Подключён новый клиент");
                ClientManager client = new ClientManager(socket);
                Thread thread = new Thread(client);
                thread.start();
            }
        }catch (IOException e){
                closeSocket();
            }
        }
    public void closeSocket() { // отдельно т.к. для закрытия сокета нужно, чтобы он был ненулевой
        //  и еще один try{} catch{}
        try {
            if (serverSocket != null) serverSocket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1300);
        Server server = new Server(serverSocket);
        server.runServer();
    }
    }


