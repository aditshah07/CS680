package edu.umb.cs.cs680.hw02;

public class DrawerClosedPlaying implements State {

	private static DVDPlayer player;
	
	private DrawerClosedPlaying(){};
   private static DrawerClosedPlaying instance = null;

   public static DrawerClosedPlaying getInstance(DVDPlayer dvdplayer){
      player = dvdplayer;
      if(instance == null){
         instance = new DrawerClosedPlaying();
      }
      return instance;
   }

   public void openCloseButtonPushed(){
   		player.stop();
   		player.open();
   		player.changeState(DrawerOpen.getInstance(player));
   }

   public void playButtonPushed(){
   		//System.err.println("DVDPlayer is already playing");
   }

   public void stopButtonPushed(){
   		player.stop();
   		player.changeState(DrawerClosedNotPlaying.getInstance(player));
   }
}