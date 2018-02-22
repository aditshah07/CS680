package edu.umb.cs.cs680.hw02;
 
public class DVDPlayer{

	private DVDPlayer(){};
	private static DVDPlayer instance = null;
	static State state;

	public static DVDPlayer getInstance() {

      if(instance == null) {
         instance = new DVDPlayer();
         state = DrawerClosedNotPlaying.getInstance(instance);
      }
      return instance;
   	}

	public void changeState(State newState){
		this.state = newState;
	}

	public void openCloseButtonPushed(){
		state.openCloseButtonPushed();
	}

	public void playButtonPushed(){
		state.playButtonPushed();
	}

	public void stopButtonPushed(){
		state.stopButtonPushed();
	}

	public String open(){
		return "Opening the DVDPlayer";
	}

	public String close(){
		return "Closing the DVDPlayer";
	}

	public String play(){
		return "Playing the DVDPlayer";
	}

	public String stop(){
		return "Stoping the DVDPlayer";
	}
}