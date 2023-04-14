package 채팅프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
	
	//현재까지 연결된 클라이언트 socket 저장
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	
	private Socket socket = null;
	
	public Server(Socket socket) {
		//클라이언트마다 소켓 생성 > ArrayList에 저장
		this.socket = socket;
		socketList.add(socket);
	}
	
	public void run() {
		//클라이언트가 접속하여 해당 클라이언트에 대한 ip주소 출력
		System.out.println(socket.getInetAddress() + "님이 연결되었습니다.");
		
		
		try {
			//클라이언트가 보낸 메시지 읽어들이는 통로 생성
			InputStream input = socket.getInputStream();
			//인풋스트림의 데이터를 읽어들이고 버퍼에 저장하는 객체 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			//서버가 클라이언트에게 메세지를 보낼 수 있는 통로 생성
			OutputStream out = socket.getOutputStream();
			//아웃풋스트림의 데이터를 읽어들이는 객체 생성
			PrintWriter writer = new PrintWriter(out, true);
			
			writer.println("사용할 닉네임 >> ");
			
			String nick = null;
			String readValue; //클라이언트가 입력한 값
			boolean check = false; //사용자가 닉네임을 입력했으면 true, 안했으면 false
			
			while((readValue = reader.readLine()) != null) {
				if(!check) {
				nick = readValue; //사용자가 처음 입력하는 내용
				check = true;
				writer.println(nick + "님이 성공적으로 접속했습니다.");
				}else {
					for(Socket s : socketList) {
						out = s.getOutputStream();
						writer = new PrintWriter(out, true);
						writer.println(nick + " : " + readValue);
					}
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
