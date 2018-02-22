package edu.umb.cs.cs680.hw02;

public class DrawerOpen implements State {
	
	private static DVDPlayer player;
   private DrawerOpen(){};
   private static DrawerOpen instance = null;

   public static DrawerOpen getInstance(DVDPlayer dvdplayer){
      player = dvdplayer;
      if(instance == null){
         instance = new DrawerOpen();
      }
      return instance;
   }

   public void openCloseButtonPushed(){
   		player.close();
   		player.changeState(DrawerClosedNotPlaying.getInstance(player));
   }

   public void playButtonPushed(){
   		player.close();
   		player.play();
   		player.changeState(DrawerClosedPlaying.getInstance(player));
   }

   public void stopButtonPushed(){
  		//Empty: System.err.println("DVDPlayer is open cannot stop playing");
   }
}