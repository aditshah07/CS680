package edu.umb.cs.cs680.hw02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;

public class DrawerClosedPlayingTest {

	@Test
	public void openCloseButtonPushed(){

		DVDPlayer player;
		player = DVDPlayer.getInstance();
		DVDPlayer playerTest = null;
		playerTest = DVDPlayer.getInstance();

		player.playButtonPushed(); //To bring it in DrawerClosedPlaying State
		player.openCloseButtonPushed();
		State actual = player.state;
		State expected = DrawerOpen.getInstance(playerTest);

		assertThat(actual,is(expected)); //Checking the states
	}

	@Test
	public void playButtonPushed(){

		DVDPlayer player = null;
		player = DVDPlayer.getInstance();
		DVDPlayer playerTest = null;
		playerTest = DVDPlayer.getInstance();

		player.playButtonPushed(); //To bring it in DrawerClosedPlaying State
		player.playButtonPushed();
		State actual = player.state;
		State expected = DrawerClosedPlaying.getInstance(playerTest);

		assertThat(actual,is(expected)); //Checking the states
	}

	@Test
	public void stopButtonPushed(){

		DVDPlayer player = null;
		player = DVDPlayer.getInstance();
		DVDPlayer playerTest = null;
		playerTest = DVDPlayer.getInstance();

		player.playButtonPushed(); //To bring it in DrawerClosedPlaying State
		player.stopButtonPushed();

		State actual = player.state;
		State expected = DrawerClosedNotPlaying.getInstance(playerTest);
		
		assertThat(actual,is(expected)); //Checking the states 
	}
	
}
