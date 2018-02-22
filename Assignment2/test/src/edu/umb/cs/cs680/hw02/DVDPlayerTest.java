package edu.umb.cs.cs680.hw02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*; 
import org.junit.Test;

public class DVDPlayerTest {

	@Test
	public void getInstance(){
		DVDPlayer player = null;
		player = DVDPlayer.getInstance();
		DVDPlayer playerTest = null;
		playerTest = DVDPlayer.getInstance();

		assertThat(player.hashCode(),is(playerTest.hashCode()));
	}

}