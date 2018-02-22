package edu.umb.cs.cs680.hw02;

public class DrawerClosedNotPlaying implements State {

	private static DVDPlayer player;
	private DrawerClosedNotPlaying(){};
   private static DrawerClosedNotPlaying instance = null;

	public static DrawerClosedNotPlaying getInstance(DVDPlayer dvdplayer){
      player = dvdplayer;
      if(instance == null){
         instance = new DrawerClosedNotPlaying();
      }
		return instance;
	}

   public void openCloseButtonPushed(){
   		player.open();
   		player.changeState(DrawerOpen.getInstance(player));
   }

   public void playButtonPushed(){
   		player.play();
   		player.changeState(DrawerClosedPlaying.getInstance(player));   		
   }

   public void stopButtonPushed(){
   		//Empty: DVDPlayer is already in stop mode and closed.
   }
}