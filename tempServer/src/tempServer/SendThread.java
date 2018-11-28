package tempServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread {
	
	private Socket m_socket;
	
	@Override 
	public void run() {
		super.run();
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_socket.getInputStream()));
			PrintWriter sendWriter = new PrintWriter(m_socket.getOutputStream());
			String sendString;
			
			while(true) {
				sendString = tmpbuf.readLine();
				
				sendWriter.println(sendString);
				sendWriter.flush();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setSocket(Socket _socket) {
		m_socket = _socket;
	}
}
