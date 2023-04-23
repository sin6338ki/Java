
package VIEW;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.SetOfIntegerSyntax;

import CONTROLLER.BgmController;
import CONTROLLER.CharDAO;
import CONTROLLER.GameDAO;
import CONTROLLER.UserDAO;
import MODEL.CharVO;

public class StartMain {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserDAO uDAO = new UserDAO();
		CharDAO cDAO = new CharDAO();
		GameDAO gDAO = new GameDAO();
		BgmController bgm = new BgmController();
		bgm.bgmList();// 0  : 시작음악 , 1 : 게임중 음악 , 2. : 엔딩(종료) 음악 , 3. : 버튼 효과음 , 4. : 스트레스 70이상일때 효과음, 5. : 죽음

		gameStart();
		bgm.playBgm(0); //시작음악
		sc.nextLine();

		int choice;

		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("                                   스인개 개발자 키우기                       [-][ㅁ][x]");
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("   [1] 회원가입      [2] 로그인      [3] 게임설명      [4] 회원탈퇴      [5] 게임종료            ");
			System.out.println("----------------------------------------------------------------------------------------");
			  System.out.print("                                     메뉴 선택  >>  "); choice = sc.nextInt();


			if (choice == 1) { // 회원가입
				bgm.playBgm(3); //버튼효과음
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                      Sign Up                                           ");
				System.out.println("----------------------------------------------------------------------------------------");
				
				String inputId = inputId();
				String inputPw = inputPw();
				
				System.out.print("                                    NICK : ");
				String inputNick = sc.next();

				int result = uDAO.join(inputId, inputPw, inputNick);
				if(result >0) {
					bgm.playBgm(3); //버튼효과음
					System.out.println("\nWELCOME   WELCOME   WELCOME   회원 가입 성공, " + inputNick + "님 환영합니다!   WELCOME   WELCOME   WELCOME");
				}

				//DB에 ID/PW 저장

			} else if (choice == 2) { // 로그인
				bgm.playBgm(3); //버튼효과음
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                      LOG IN                                            ");
				System.out.println("----------------------------------------------------------------------------------------");
				String inputId = inputId();
				String inputPw = inputPw();
				String nick = uDAO.login(inputId, inputPw);

				if(nick != null) {
					bgm.playBgm(3); //버튼효과음
					System.out.println("\nWELCOME   WELCOME   WELCOME   " + nick + "님이 로그인하셨습니다!   WELCOME   WELCOME   WELCOME");
					System.out.println();
					boolean inputError = false;
					boolean firstTry = true;
					while(firstTry == true || inputError == true) {
						
						System.out.println("----------------------------------------------------------------------------------------");
						System.out.println("                                          MENU                                 [-][ㅁ][x]");
						System.out.println("----------------------------------------------------------------------------------------");
						System.out.println("             [1]스인개 개발자 키우기       [2]캐릭터 조회        [3]랭킹 확인                      ");
						System.out.println("                        [4]캐릭터 삭제            [5]시작메뉴 이동                           "); 
						System.out.println("----------------------------------------------------------------------------------------");
						System.out.print("                                        메뉴 선택   >>  "); choice = sc.nextInt();
						System.out.println("----------------------------------------------------------------------------------------");

						if(choice == 1) { //스인재 개발자 키우기
							bgm.playBgm(3); //버튼효과음
							bgm.playBgm(1); //게임중음악
							boolean sw = false;
							
//							if(uDAO.checkNickDuplication(nick)) continue;
							
							if(gDAO.categoryChar(nick) == -1) {
								makeChar(nick);
							}else {
								
								stateOfChar(nick);
								for(int i = 0 ; i < gDAO.userCharList().size(); i++) {
									if(gDAO.userCharList().get(i).getNick().equals(nick)) {
//										gDAO.callChar(nick);
										sw = false;
										break;
									}else {
										sw = true;
									}
								}
							}
							

							if(sw) {
								makeChar(nick);
							}
							
							playMenu(nick);
							


//							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//							System.out.println("                  |                         캐릭터 생성                       [-][ㅁ][x] |");
//							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//							System.out.println("                  |   [1] 풀스택 개발자     [2] 데이터베이스 관리자     [3] 인공지능 개발자      | ");
//							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//							System.out.print("                                            메뉴 선택    >>  "); choice = sc.nextInt();
//							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//
//							if (choice == 1) { // 풀스택 개발자 플레이
//								gDAO.creationChar(nick); 
//								artFullStack();
//								playMenu(nick);
//							} else if (choice == 2) { // 데이터베이스 관리자 플레이
//								gDAO.creationChar(nick); 
//								artDB();
//								playMenu(nick);
//							} else if (choice == 3){ // 인공지능 개발자 플레이
//								gDAO.creationChar(nick); 
//								artAI();
//								playMenu(nick);
//							} else {
//								inputError = true;
//								System.out.println("잘못된 입력입니다. 첫 화면으로 돌아갑니다.");
//								continue;
//							}

						}else if(choice == 2){ //캐릭터 조회
							bgm.playBgm(3); //버튼효과음
							
							if(gDAO.existNickYn(nick).equals("N")) {
				                System.out.println("                                 캐릭터 생성이 필요합니다...                                       ");
								continue;
							}
							
//							playMenu(nick);
							
							stateOfChar(nick);
							
							categoryOfChar(nick);
							
						}
//							else if(choice == 3) { //
//							
//							if(gDAO.existNickYn(nick).equals("N")) {
//				                System.out.println("\n                                    캐릭터 생성이 필요합니다..");
//								continue;
//							}
//							
//							ArrayList<Integer> charGauge = gDAO.charGauge(nick);
//
//							System.out.println(nick + " =========> "
//									+ "Exp : " + charGauge.get(0)
//									+ " / Stress : " + charGauge.get(1)
//									+ " / Hp : " + charGauge.get(2));
//
//						}
//							else if(choice == 3) { //닉네임변경
//							System.out.println("                  |                 ID와 변경할 새로운 닉네임을 입력해주세요                  |");
//							System.out.println("                   ㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
//							System.out.print("                                             ID : ");
//							inputId = sc.next();
//							System.out.print("                                           New_Nick : ");
//							String newNick = sc.next();
//							int result = uDAO.updateNick(inputId, newNick);
//
//						}
							else if(choice == 3) { //랭킹확인
							//                   String nickName = sc.next();

//							ArrayList<CharVO> charList = gDAO.rank();
//
//							for(int i=0; i<charList.size(); i++) {
//								System.out.println(charList.get(i).getNick()+" / "+charList.get(i).getExp());
//							}
							
					
							System.out.println("----------------------------------------------------------------------------------------");
							System.out.println("                                  랭킹 확인                                 [-][ㅁ][x]");
							System.out.println("----------------------------------------------------------------------------------------");
							bgm.playBgm(3); //버튼효과음
							
							for (int i = 0; i < gDAO.rank().size(); i++) {
								CharVO temp = gDAO.rank().get(i);
								String userNick = temp.getNick();
								int userExp = temp.getExp();
//								int userStress = temp.getStress();
//								int userHp = temp.getHp();
								
								System.out.printf("                               닉네임 : %s  EXP : %d	                          \n", userNick, userExp);
								System.out.println("----------------------------------------------------------------------------------------");

							}

						}else if(choice == 4){ //캐릭터삭제     //USER_NICK 컬럼밖에 없음
							bgm.playBgm(3); //버튼효과음
							System.out.print("                                             닉네임 : ");
							String inputNick = sc.next();
							
//							inputId = inputId();
//							inputPw = inputPw();
							gDAO.deleteChar(inputNick);

							if(gDAO.deleteChar(nick)>=0) {
								System.out.println("\nbye  bye  bye  bye  bye  bye       캐릭터 삭제 완료         bye  bye  bye  bye  bye  bye\n");
							}
							
						}else if(choice == 5){
							break;
						}
					}
				}else {
					//               System.out.println("\n   Not_Found   일치하는 회원정보가 없습니다. 다시 로그인해주세요      Not_Found  \n");
					continue;
				}

				//            
			} else if (choice == 3) { // 게임설명
				bgm.playBgm(3); //버튼 효과음
				gameIntroduce();
				choice = sc.nextInt();
				if(choice == 1) {
					continue;
				}else {
					bgm.playBgm(5); //게임종료 효과음
					System.out.println("\nbye  bye  bye  bye  bye  bye        게임을  종료합니다         bye  bye  bye  bye  bye  bye\n");
					break;
				}

				//         } else if (choice == 4) { // 게임종료
				//            System.out.println("\n                    bye bye bye bye bye bye  게임을  종료합니다   bye bye bye bye bye bye\n");
				//            break;
				//            
			} else if (choice == 4) { // 회원탈퇴
				bgm.playBgm(3); //버튼 효과음
				System.out.println("                             탈퇴를 위해 ID, PW를 입력하세요                                     ");
				System.out.println("----------------------------------------------------------------------------------------");
				String inputId = inputId();
				String inputPw = inputPw();
				int result = uDAO.deleteUser(inputId, inputPw);

			}else if (choice == 5) { // 게임종료
				bgm.playBgm(2); //엔딩(종료) 음악
				System.out.println("\nbye  bye  bye  bye  bye  bye        게임을  종료합니다         bye  bye  bye  bye  bye  bye\n");
				break;

			} else {
				bgm.playBgm(3); //버튼 효과음
				System.out.println();
				System.out.println("\nbye  bye  bye  bye  bye  bye        게임을  종료합니다         bye  bye  bye  bye  bye  bye\n");
				System.out.println("\nerror   error   error   error       메뉴를 다시 선택해주세요        error   error   error   error");
				System.out.println();
				continue;
			}
		} //main 끝
	}
	
	public static void game() {
		System.out.println("GAME START");
		System.out.println("풀스택 개발자 키우기");
	}

	public static void gameStart() {
		System.out.println("\r\n"
				+ " ____  ____  ____  ____  ____  ____  ____  _________  ____  ____  ____  ____  ____  ____  ____  ____  ____  \r\n"
				+ "||S ||||M ||||H ||||R ||||D ||||  ||||  ||||       ||||  ||||  ||||  ||||  ||||  ||||  ||||  ||||  ||||  ||\r\n"
				+ "||__||||__||||__||||__||||__||||__||||__||||_______||||__||||__||||__||||__||||__||||__||||__||||__||||__||\r\n"
				+ "|/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/_______\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\||/__\\|\r\n");

		System.out.println(
				".______           ___       __       _______. __  .__   __.   _______     \r\n"
						+ "|   _  \\         /   \\     |  |     /       ||  | |  \\ |  |  /  _____|  \r\n"
						+ "|  |_)  |       /  ^  \\    |  |    |   (----`|  | |   \\|  | |  |  __     \r\n"
						+ "|      /       /  /_\\  \\   |  |     \\   \\    |  | |  . `  | |  | |_ |   \r\n"
						+ "|  |\\  \\----. /  _____  \\  |  | .----)   |   |  | |  |\\   | |  |__| |   \r\n"
						+ "| _| `._____|/__/     \\__\\ |__| |_______/    |__| |__| \\__|  \\______|    \r\n"
						+ "                                                                              \r\n"
						+ " _______   _______ ____    ____  _______  __        ______   .______    _______ .______           _______.\r\n"
						+ "|       \\ |   ____|\\   \\  /   / |   ____||  |      /  __  \\  |   _  \\  |   ____||   _  \\         /       |\r\n"
						+ "|  .--.  ||  |__    \\   \\/   /  |  |__   |  |     |  |  |  | |  |_)  | |  |__   |  |_)  |       |   (----`\r\n"
						+ "|  |  |  ||   __|    \\      /   |   __|  |  |     |  |  |  | |   ___/  |   __|  |      /         \\   \\    \r\n"
						+ "|  '--'  ||  |____    \\    /    |  |____ |  `----.|  `--'  | |  |      |  |____ |  |\\  \\----..----)   |   \r\n"
						+ "|_______/ |_______|    \\__/     |_______||_______| \\______/  | _|      |_______|| _| `._____||_______/    \r\n"
						+ "                                                        \r\n"
		                + "                                                            ");
		System.out.println("                             E   N   T   E   R                                              ");
	}

	public static void gameIntroduce() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("                                게  임  설  명                               [-][ㅁ][x]");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("                     스마트인재개발원 수강신청에 성공한 당신!                              ");
		System.out.println("   당신은 풀스택 개발자, 데이터베이스 관리자, 인공지능 개발자 코스 중 하나를 선택하여                  ");
		System.out.println("            능력 있는 개발자가 되기 위한 스인개 생활을 시작하게 되었습니다!                         ");
		System.out.println("                                                                                        ");
		System.out.println("      [스인개 수업듣기] [팀프로젝트] [코딩테스트] [자격증 공부] [예습/복습] 을 통해               ");
		System.out.println("   개발 능력치를 상승시킬 수 있으나 무리한공부는 체력감소와 스트레스상승의 원인이 됩니다!              ");
		System.out.println(" 스트레스 게이지가 100 초과시 혹은 체력 게이지가 0이 되는 순간 스인재에서 퇴소당하는 불상사가 발생하니        ");
		System.out.println("   [점심시간] [커피마시기] [수업시간에 졸기] [퇴근] [주말에 쉬기] 등을 적절히 수행하여            ");
		System.out.println("                 건강하고 능력있는 개발자가 되기 위해 노력해주세요!                            ");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------"); 
		System.out.print("                  1. 시작메뉴로 돌아가기        2. 게임종료    >>   ");
	}

	public static void artFullStack() {
		System.out.println(
						 "                 ------------------------\r\n"
						+"                |     나는,,,             |\r\n"
						+"                |     개발자중의 개발자라능,,,! |\r\n"
						+"                -----ヽ__ノ----------------\r\n"
						+ "                     Ｏ\r\n"
						+ "                      o\r\n"
					    + "                                     　　 ¸ ― ― ―｜  ― ￣￣;;　;;￣￣;;｀、 　＼\r\n"
			            + "                                     　　｜　　　/　　　　;;　;; 　　;;　＼　　　　　　 　＼\r\n"
			            + "                                     　　｜　　/　　　　　;; 　 ;;　 　;;　　＼ 　　 　　　＼\r\n"
			            + "                                 　　　 ｜　/　　　　　　;　　;; 　 　;;　　 ＼　　　　 　＼\r\n"
			            + "                                     　　｀ /　　　　　　　　　 ;　　　;;　　｀　　　 　　＼\r\n"
			            + "　                                　　　 / 　　　¸　　　　　　　　　　　__--｀　　 　　ㅣ\r\n"
			            + "　                               　　　/=====;;＇¸　＼;;=====;.˛　　　＼　　 　 　 ㅣ\r\n"
			            + "　                                 　　 /________/　　;;____　　　':　　　 　＼　　 　 　ㅣ\r\n"
			            + "　                                　　｜ 　 　 /　　　'_ 　 ￣￣￣=--　　　　｜　　　 　 ｜\r\n"
			            + "　                                　　 /￣　　/　　　 　　　　＇￣　　 　 　｜　　　 　｜\r\n"
			            + "　                                　　/ 　　／ 。 　 ´·， 　　　　　　　　 　｜　　　　　｜\r\n"
			            + "　                             　　 ｜ 　　(·.¸　˛.-·-.¸_)　　　　　 　 　　 　｜　　　 　｜\r\n"
			            + "　                               　　｜ 　 　，￣ 　　　｜　　　　 　　 　｜　¸.·´˚｀·¸　 ｜\r\n"
			            + "　                                    　｜　　／ _　　　　 ｜　　　　 　　 ｜ 　／¸----. ｜ ｜\r\n"
			            + "　                                     　｜　 ／˛＿＿＿＿__¸　　　　 　　　└―＿／ ｜　ㅣ｜ ｜\r\n"
			            + "　                                     　 ｜　 /　/￣￣￣￣￣/ 　　　　　　　　 　 　｜ 　 │ / 　\r\n"
			            + "　                                     　 ｜　　˛/―――――/　　　　　　　　　　 　 　　／/ ｜\r\n"
			            + "　                                     　 ｜　 　￣￣￣￣￣ 　　　　　　　　 　　　　￣　/　　｜\r\n"
			            + "　                                      　｜　　　　　　　　　　　　　 　　 　　＿＿＿.·˙　 　｜\r\n"
			            + "　                                      　｜ 　 ￣￣￣￣　　　　　　 　　 　/　　｜　　 　｜\r\n"
			            + "　                   　｜　　　　　　　　　　　　　　　　　　｜　　 　｜\r\n"
			            + "　                                        　｜　　　　　　　　　˛.·　\r\n"
			            + "　 　                  ｜＿＿＿ 　　　　˛.·＇\r\n"
			            + "　 　                  　＼￣ 　￣￣￣￣");

	}

	public static void artDB() {
		System.out.println(
						 "                       ------------------------------\r\n"
						+"                      |   너도 하나의 데이터일뿐.... |\r\n"
						+"                      |                              | \r\n"
						+"                       ----------ヽ___ノ---------------\r\n"
						+ "                             Ｏ\r\n"
						+ "                              o\r\n"
						+ "                           .~-                      \r\n"
						+ "                             -$@@@@~                \r\n"
						+ "                            .@@@@@@@-               \r\n"
						+ "                            #@@@@@@@@               \r\n"
						+ "                            @@@@@@@@@.              \r\n"
						+ "                            =DBDBDBD.#              \r\n"
						+ "                           @,        @              \r\n"
						+ "                           @=  = =  !@              \r\n"
						+ "                           .#,  L   @~              \r\n"
						+ "                            .=  -- ;;               \r\n"
						+ "                             *;   .@                \r\n"
						+ "                              $!~:#      ,~~;;:~-   \r\n"
						+ "                               ~=*     ,#@@@@@@@@@. \r\n"
						+ "                             @     =.  @@@@@@@@@@@: \r\n"
						+ "                           @,=@   ~@ @ :@@@@@@@@@@. \r\n"
						+ "                         .@@@ @* ~@ @@ ;  -@@@@!  . \r\n"
						+ "                         @@@@!,,  =.@@ @@#$!,.~$#@~ \r\n"
						+ "                        =@@@@@-:@=.@@@ @@@@@@@@@@@~ \r\n"
						+ "                        .@@@@@@@@@@@@@@ $@@@@@@@@@@~ \r\n"
						+ "                                            ");
	}

	public static void artAI() {
		System.out.println(
				         "                      ----------------------------\r\n"
						+"                     |  사람과 함께 공존하며        |\r\n"
						+"                     |   더 높은곳을 향할것입니다     |\r\n"
						+"                      -----ヽ___ノ-------------------\r\n"
						+ "                             Ｏ\r\n"
						+ "                              o\r\n"
						+ "                             :#############:     \r\n"
						+ "                             =.-----------.=     \r\n"
						+ "                            :,:=!!!!!!!!!*;.:    \r\n"
						+ "                           ~!,:- -!. .!- ,;.*~   \r\n"
						+ "                         , !;,:- ~;- -;~ ,;.;! . \r\n"
						+ "                        $~=:~,:@@~~ ~~-@@  .~:=~$\r\n"
						+ "                        @!=:~,:-.-~~U~~-.,;.~:$!@\r\n"
						+ "                         , !;,:- ~;---;- ,;.;! , \r\n"
						+ "                           ~!,:- ~*. .*~ ,;.!~   \r\n"
						+ "                            :,:*;;;;;;;;;*:.;    \r\n"
						+ "                             *.~~~~~~~~~~~.*     \r\n"
						+ "                             ~$$$$$$$$$$$$$~     \r\n"
						+ "                                   $ $           \r\n"
						+ "                               ,#$$$@$$$#,       \r\n"
						+ "                              .;=~~~@~~~=;.      \r\n"
						+ "                              !;;!*!;!**;;*      \r\n"
						+ "                             ;;  ,~   ~,  :;     \r\n"
						+ "                             #   ,~   ~,   #     \r\n"
						+ "                             #    *, ,*    #     \r\n"
						+ "                            =$@   !@.@!   @$=    \r\n"
						+ "                            *~*   ,*-*,   *~*    \r\n"
						+ "                            -;    *, ,*    ;-    \r\n"
						+ "                                ,!#- -#!,        \r\n"
						+ "                               .!-:~ ~:-!.       \r\n"
						+ "                               ,@#@: :@#@,       ");
	}

	public static void playMenu(String nick) {
		
		BgmController bgm = new BgmController();
		bgm.bgmList();
		CharDAO cDAO = new CharDAO();
		GameDAO gDAO = new GameDAO();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {

			if(gDAO.charGauge(nick).get(1) >= 100) {
				bgm.playBgm(2);
				gameOverStress();
				break;
			}else if(gDAO.charGauge(nick).get(2) <= 0) {
				bgm.playBgm(2);
				gameOverHp();
				break;
			}
			
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("                            행동을 선택해 주세요                             [-][ㅁ][x]");
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("                  |번호선택|                 행 동                                           ");
			System.out.println("                  |  1  |              스인개 출근하기                                        ");
			System.out.println("                  |  2  |              스인개 수업듣기                                        ");
			System.out.println("                  |  3  |               팀 프로젝트                                         ");
			System.out.println("                  |  4  |                코딩테스트                                         ");
			System.out.println("                  |  5  |               자격증 공부                                         ");
			System.out.println("                  |  6  |                예습 복습                                         ");
			System.out.println("                  |  7  |                점심 시간                                         ");
			System.out.println("                  |  8  |                집에 가기                                         ");
			System.out.println("                  |  9  |              월요일 5시 퇴근                                       ");
			System.out.println("                  |  10 |              수업시간에 졸기                                        ");
			System.out.println("                  |  11 |               주말에 쉬기                                          ");
			System.out.println("                  |  12 |               커피 마시기                                          ");
			System.out.println("                  |  0  |                그만하기                                           ");
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.print("                                      행동 선택   >>  "); choice = sc.nextInt();
			System.out.println("----------------------------------------------------------------------------------------");
			
			if (choice == 1) {
				bgm.playBgm(3); //버튼효과음
				cDAO.goSmhrd(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                   스인개 출근                               [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                               하루하루 『진화』 중이라능,,,!                                ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 0) {
				bgm.playBgm(3); //버튼효과음
				break;
			} else if (choice == 2) {
				bgm.playBgm(3); //버튼효과음
				cDAO.listeningClass(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                               스인개 수업 듣기                              [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                             야레야레,,   『쉬울』뿐,,                                   ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 3) {
				bgm.playBgm(3); //버튼효과음
				cDAO.teamProject(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                 팀 프 로 젝 트                              [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                              훗,,,난 『ACE』라능,,,!                                   ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 4) {
				bgm.playBgm(3); //버튼효과음
				cDAO.codingTest(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                              코 딩 테 스 트                                [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                       압도적인 『노력』의 결과를 보여줄 차례인가,,,                             ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 5) {
				bgm.playBgm(3); //버튼효과음
				cDAO.studyCertificate(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                             정처기 자격증 획득!                             [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                         또 하나의 『능력』을 얻었다능,,,!                                 ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 6) {
				bgm.playBgm(3); //버튼효과음
				cDAO.selfEdu(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                             집에서 예습과 복습;                             [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                        오오오옷,,,『능력치』가 솟아오른다능,,,                               ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 7) {
				bgm.playBgm(3); //버튼효과음
				cDAO.lunchTime(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                               점심 먹으러 !!                             [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                            이몸은 무려 『육식』파라능,,,!                                  ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 8) {
				bgm.playBgm(3); //버튼효과음
				cDAO.goHome(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                             수업 끝! 집에 갑니당!                            [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                  가벼운 나의 발걸음은 너의 『달림』을 뛰어 넘는다능,,,!                         ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 9) {
				bgm.playBgm(3); //버튼효과음
				cDAO.monday(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                             월요일은 5시 끝 >_<                            [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                       후훗,,,나란 놈은『시간』을 조종한다능,,,!                            ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 10) {
				bgm.playBgm(3); //버튼효과음
				cDAO.snooze(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                              수업시간에 졸기                                [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                       단지,,,『추진력』을 얻기 위함이라능,,,!                              ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 11) {
				bgm.playBgm(3); //버튼효과음
				cDAO.weekend(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                주말엔 쉬어요                              [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                           내가 쉬면 『이세계』도 멈춘다능,,,!                             ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			} else if (choice == 12) {
				bgm.playBgm(3); //버튼효과음
				cDAO.coffee(nick);
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                              커피로 카페인 충전                             [-][ㅁ][x]");
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("                                                                                        ");
				System.out.println("                          내 『혈류』는 이미 블랙이라능,,,                                ");
				System.out.println("                                                                                        ");
				System.out.println("----------------------------------------------------------------------------------------");
			}
			
//			stateOfChar(nick);
		}
		
	}
	
	public static void chat1() {
		System.out.println("----------------------------------------------------------------------------------------");
	}
	   
	   
	public static String inputId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("                                      ID : ");
		String id = sc.next();
		return id;
	}

	public static String inputPw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("                                      PW : ");
		String pw = sc.next();
		return pw;
	}
	
	public static void makeChar(String nick) {
		boolean inputError = false;
		Scanner sc = new Scanner(System.in);
		GameDAO gDAO = new GameDAO();
		int choice ;
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("                            내 캐릭터 만들기                              [-][ㅁ][x]");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("             [1] 풀스택 개발자    [2] 데이터베이스 관리자   [3] 인공지능 개발자                   ");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.print("                                      메뉴 선택   >>  "); choice = sc.nextInt();
		System.out.println("----------------------------------------------------------------------------------------");

		if (choice == 1) { // 풀스택 개발자 플레이
			gDAO.creationChar(nick, choice); 
			artFullStack();
//			playMenu(nick);
		} else if (choice == 2) { // 데이터베이스 관리자 플레이
			gDAO.creationChar(nick, choice); 
			artDB();
//			playMenu(nick);
		} else if (choice == 3){ // 인공지능 개발자 플레이
			gDAO.creationChar(nick, choice); 
			artAI();
//			playMenu(nick);
		} else {
			inputError = true;
			System.out.println("\nerror   error   error   error       잘못된 입력입니다        error   error   error   error");
			System.out.println("\nerror   error   error   error      첫화면으로 돌아갑니다       error   error   error   error");
//			continue;
		}

	}
	
	public static void stateOfChar(String nick) {
		
		GameDAO gDAO = new GameDAO();
		int userExp = gDAO.charGauge(nick).get(0);
		int userStress = gDAO.charGauge(nick).get(1);
		int userHp = gDAO.charGauge(nick).get(2);
		
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("                                     내 캐릭터 조회하기                              [-][ㅁ][x]");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("                                   EXP     >>   " + userExp);
//		System.out.println("                                   HP      >>   " + userHp);
//		System.out.println("                                   STRESS  >>   " + userStress);
		System.out.println("----------------------------------------------------------------------------------------");

	}
	
	public static void categoryOfChar(String nick) {
		
		GameDAO gDAO = new GameDAO();
		int charNum = gDAO.categoryChar(nick);
		
		if(charNum == 0) { //풀스택개발자
			artFullStack();
		}else if(charNum == 1) { //데이터베이스 관리자
			artDB();
		}else if(charNum == 2) { //AI 개발자
			artAI();
		}

	}
	
	   //캐릭터 죽음
	   public static void gameOverHp() {
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("                                       Game Over                               [-][ㅁ][x]");
			System.out.println("----------------------------------------------------------------------------------------");
	       System.out.println("                                  ---.       \r\n"
	    		   + "                                                      \r\n"
	               + "                                          #####-      \r\n"
	               + "                                         #######,     \r\n"
	               + "                                        ,#######~     \r\n"
	               + "                                    !##:,#######;     \r\n"
	               + "                                   !####*#######~     \r\n"
	               + "                                  !#####=######@,     \r\n"
	               + "                                 !######= $####,      \r\n"
	               + "                                 #######~  .:,        \r\n"
	               + "                                $#######~             \r\n"
	               + "                               -########*             \r\n"
	               + "                               @########=             \r\n"
	               + "                              ,######=##=             \r\n"
	               + "                              *#####=,##$             \r\n"
	               + "                              ######  ##@             \r\n"
	               + "                             ,#####=  @##             \r\n"
	               + "                             ~#####=  $###.           \r\n"
	               + "                             ~#####;  -@##@,          \r\n"
	               + "                             ,######:  -###@-         \r\n"
	               + "                              ~@#####:  ,###@.        \r\n"
	               + "                                =#####;  .###=        \r\n"
	               + "                                 !#####=  ,#@         \r\n"
	               + "                                  :######             \r\n"
	               + "                             .=@@########@.           \r\n"
	               + "                             :############,           \r\n"
	               + "                             :############,           \r\n"
	               + "                             ,$@@@@##$$==$            \r\n"
	               + "                                                      \r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                        ..............................\r\n"
	               + "                            #$$$=$###############$$$$$$$$#");
	       return;
	   }
	   
	   public static void gameOverStress() {
		   System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("                                       Game Over                               [-][ㅁ][x]");
			System.out.println("----------------------------------------------------------------------------------------");
	       System.out.println("                                             \r\n"
	       		   + "                            =        #       ,*       \r\n"
	               + "                            *@:$*.   #   ,$*:@;       \r\n"
	               + "                        .  .  $=;~       !-$$  .      \r\n"
	    		   + "                                                      \r\n"               
	    		   + "                                                      \r\n"
	               + "                        #=.@.                 ~# @$   \r\n"
	               + "                         @@@@!   !@@@@@@@-   *#@@@    \r\n"
	               + "                          @!    #@@@@@@@@@@    ;@     \r\n"
	               + "                               *@@. ~@@@@@@:          \r\n"
	               + "                               #@~~#~,@@@@@#          \r\n"
	               + "                               @,~$@@! -~~~@          \r\n"
	               + "                             * : @@@@@@*!! ;.;        \r\n"
	               + "                             @.~ @$!#@#!@@ -~@        \r\n"
	               + "                             # @ @ ~,@ ~ @ @ $        \r\n"
	               + "                            :  ; @-@~@~@-@ - .~       \r\n"
	               + "                           ~@    @@@@@@@@@   ~@.      \r\n"
	               + "                           @@    $@@   @@*    @#      \r\n"
	               + "                          ~@-    -@*-@ @@.    :@      \r\n"
	               + "                          @@      -@@@@@,     ,@@     \r\n"
	               + "                         ~@$       .@@@        @@     \r\n"
	               + "                         ~@*;-      @@@      -!=@     \r\n"
	               + "                         ,@@@@@@#~-~~@-;.!@@@@@@@     \r\n"
	               + "                          .!!@@@@*-@--:@.#~           \r\n"
	               + "                               ~*@ # - @ @ @@@@@@@@@@@\r\n"
	               + "                                 @-  $  ~@ @@@@@*@@@@@\r\n"
	               + "                                 @*#~ ,@#@ @@@@; #@@@@\r\n"
	               + "                                 @@@ $ @@@ @@@@@-@@@@@\r\n"
	               + "                                 @@@ # @@@ @@@@@@@@@@@\r\n"
	               + "                                 @@@ # @@@ @@@@@@@@@@@\r\n"
	               + "                                 @@*-@ @@@ @@@@@@@@@@@\r\n"
	               + "                                 @@*-@ @@@            \r\n"
	               + "                                 @@*-@ @@@            \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                            @@*-@ @@@ \r\n"
	               + "                                           $@@@@@@@@@=");
	       return;
	         
	   }
}