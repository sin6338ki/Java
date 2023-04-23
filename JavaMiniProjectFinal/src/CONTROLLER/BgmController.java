
package CONTROLLER;

import java.util.ArrayList;
import MODEL.BgmVO;
import javazoom.jl.player.MP3Player;

public class BgmController {
   
   ArrayList<BgmVO> bgmList = new ArrayList<BgmVO>(6);
   MP3Player mp3 = new MP3Player();
   MP3Player mp3_2 = new MP3Player();
   
   public void bgmList() {
      bgmList.add(new BgmVO("bgm/startBgm.mp3"));
      bgmList.add(new BgmVO("bgm/playBgm.mp3"));
      bgmList.add(new BgmVO("bgm/endBgm.mp3"));
      bgmList.add(new BgmVO("bgm/Button.mp3"));
      bgmList.add(new BgmVO("bgm/Stress70.mp3"));
      bgmList.add(new BgmVO("bgm/Die.mp3"));
      
   }
   
  
   public void playBgm(int index) {
      if(mp3.isPlaying()) {
         //현재 재생중인 음악 정지
         mp3.stop();
      }
      //index가 가리키고 있는 위치에 음악을 재생
      mp3.play(bgmList.get(index).getSongPath());
      
   
   }
   
//   public void effectBgm(int index) {
//      if(mp3_2.isPlaying()) {
//         //현재 재생중인 음악 정지
//         mp3_2.stop();
//      }
//      //index가 가리키고 있는 위치에 음악을 재생
//      mp3_2.play(bgmList.get(index).getSongPath());
//      
//   
//   }
   
   public void stop() {
      mp3.stop();
   }
}