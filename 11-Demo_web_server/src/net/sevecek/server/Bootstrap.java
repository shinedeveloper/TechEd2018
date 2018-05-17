package net.sevecek.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Bootstrap {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(80);
		TextConsole.println("Web server is running");
		while (true) {
			Socket socket = serverSocket.accept();
			PrintWriter response = new PrintWriter(socket.getOutputStream());

			response.println("HTTP/1.1 200 OK");
			response.println("Content-Type: text/html");
			response.println("");
			response.println("<html>");
			response.println("<body>");
			response.println("<h1>Works!</h1>");
			response.println("<h2>Still alive: "+(int) (Math.random()*100.0)+"</h2>");
			response.println("</body>");
			response.println("</html>");
			response.println("");
			response.close();

			socket.close();
		}
	}

}
