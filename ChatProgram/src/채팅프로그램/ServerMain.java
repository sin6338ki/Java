package 채팅프로그램;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		
		int socketPort = 1234; //서버 포트 설정
		try {
			ServerSocket server = new ServerSocket(socketPort); //서버 열기
			//서버가 종료될 때까지 클라인트가 접속할 경우 해당 정보 server의 serverList에 저장
			while(true) {
				Socket socketUser = server.accept();
				Server socketServer = new Server(socketUser);
				socketServer.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
