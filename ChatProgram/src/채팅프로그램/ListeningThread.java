package 채팅프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListeningThread extends Thread{

	private Socket socket = null;
	
	public ListeningThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			//인풋스트림 객체 생성
			InputStream input = socket.getInputStream();
			//InputStreamReader : 스트림을 통해 들어온 데이터 읽기
			//BufferedReader : 읽은 데이터를 임시적으로 저장 (버퍼)
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			while(true) {
				//버퍼에 저장된 데이터를 가져와서 출력(반복)
				System.out.println(reader.readLine()); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
