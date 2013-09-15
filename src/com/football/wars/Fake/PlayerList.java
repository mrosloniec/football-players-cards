package com.football.wars.Fake;

import com.football.wars.R;
import com.football.wars.model.Country;
import com.football.wars.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerList {

	private final List<Player> PLAYER_LIST = new ArrayList<Player>() {{
		add(new Player(1, "Suarez", new Country(1, "Urugay", R.drawable.urugay),
				generateRandomNumber(), generateRandomNumber(), R.drawable.suarez));
		add(new Player(1, "Zidane", new Country(1, "France", R.drawable.france),
				generateRandomNumber(), generateRandomNumber(), R.drawable.zidane));
	}};

	public List<Player> getPlayerList() {
		return PLAYER_LIST;
	}

	private String generateRandomNumber() {
		Random random = new Random();
		return String.valueOf(random.nextInt(10));
	}
}
