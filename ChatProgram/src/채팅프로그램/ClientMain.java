package 채팅프로그램;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("172.30.1.59", 1234);
			System.out.println("서버 접속 성공!");
			ListeningThread lt = new ListeningThread(socket);
			WritingThread wt = new WritingThread(socket);
			
			lt.start();
			wt.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
