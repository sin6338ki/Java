package 채팅프로그램;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//WritingThread : 클라이언트가 채팅을 작성하고 작성한 채팅을 서버로 보냄
public class WritingThread extends Thread{
	
	private Socket socket = null;
	
	Scanner sc = new Scanner(System.in);
	
	public WritingThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			//아웃풋스트림 객체 생성
			OutputStream out = socket.getOutputStream();
			//통로를 통해서 데이터(텍스트) 출력
			PrintWriter writer = new PrintWriter(out, true);
			
			while(true) {
				//콘솔로 입력받은 내용을 서버에 출력
				writer.println(sc.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
