package com.football.wars.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.football.wars.Fake.PlayerList;
import com.football.wars.R;
import com.football.wars.model.Player;

import java.util.List;

public class NewGameActivity extends AbstractActivity {

	private Button playButton;
	private GridLayout card1;
	private GridLayout card2;
	private TextView player1name;
	private ImageView player1Image;
	private ImageView player1Country;
	private TextView player1attack;
	private TextView player1defense;
	private TextView player2name;
	private ImageView player2Image;
	private ImageView player2Country;
	private TextView player2attack;
	private TextView player2defense;
	private GridLayout endScreen;
	private TextView player1score;
	private TextView player2score;
	private FrameLayout layout;

	private Player player1;
	private Player player2;

	private TextView endGameText;
	private int winnerColor = Color.parseColor("#00FF00");
	private int drawColor = Color.parseColor("#0000FF");
	private int looserColor = Color.parseColor("#FF0000");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		playButton = (Button) findViewById(R.id.game_playButton);
		card1 = (GridLayout) findViewById(R.id.card1);
		card2 = (GridLayout) findViewById(R.id.card2);
		player1name = (TextView) findViewById(R.id.player1name);
		player1Image = (ImageView) findViewById(R.id.player1image);
		player1Country = (ImageView) findViewById(R.id.player1country);
		player1attack = (TextView) findViewById(R.id.player1attack);
		player1defense = (TextView) findViewById(R.id.player1defense);
		player2name = (TextView) findViewById(R.id.player2name);
		player2Image = (ImageView) findViewById(R.id.player2image);
		player2Country = (ImageView) findViewById(R.id.player2country);
		player2attack = (TextView) findViewById(R.id.player2attack);
		player2defense = (TextView) findViewById(R.id.player2defense);
		endScreen = (GridLayout) findViewById(R.id.endScreen);
		endGameText = (TextView) findViewById(R.id.endGameText);
		player1score = (TextView) findViewById(R.id.player1score);
		player2score = (TextView) findViewById(R.id.player2score);
		layout = (FrameLayout) findViewById(R.id.layout);
	}

	public void playGame(View view) {
		buttonClick.start();
		clearScreen();

		List<Player> playerList = new PlayerList().getPlayerList();

		player1 = playerList.get(0);
		setPlayer1Skills(player1);
		setVisible(card1);

		player2 = playerList.get(1);
		setPlayer2Skills(player2);
		setVisible(card2);

		setVisible(layout);
	}

	private void calculatePowersAndSetScores(Player player1, Player player2) {
		int player1attack = Integer.parseInt(player1.getAttack());
		int player1defense = Integer.parseInt(player1.getDefense());

		int player2attack = Integer.parseInt(player2.getAttack());
		int player2defense = Integer.parseInt(player2.getDefense());

		int player1power = player1attack + player1defense;
		int player2power = player2attack + player2defense;

		player1score.setText(String.valueOf(player1power));
		player2score.setText(String.valueOf(player2power));

		if (player1power < player2power) {
			setEndGameText(endGameText, R.string.gameMenu_looser, looserColor);
		} else if (player1power > player2power) {
			setEndGameText(endGameText, R.string.gameMenu_winner, winnerColor);
		} else {
			setEndGameText(endGameText, R.string.gameMenu_draw, drawColor);
		}
	}

	private void clearScreen() {
		setInvisible(card1);
		setInvisible(card2);
		setInvisible(endScreen);
		setInvisible(playButton);
		setInvisible(layout);
	}

	private void setEndGameText(TextView endGameText, int text, int color) {
		endGameText.setText(text);
		endGameText.setTextColor(color);
		setVisible(endGameText);
	}

	private void setPlayer1Skills(Player player) {
		String playerName = player.getName();
		int playerImage = player.getImage();
		int playerCountryImage = player.getCountry().getImage();
		String playerAttack = player.getAttack();
		String playerDefense = player.getDefense();

		player1name.setText(playerName);
		player1Image.setImageResource(playerImage);
		player1Country.setImageResource(playerCountryImage);
		player1attack.setText(playerAttack);
		player1defense.setText(playerDefense);
	}

	private void setPlayer2Skills(Player player) {
		String playerName = player.getName();
		int playerImage = player.getImage();
		int playerCountryImage = player.getCountry().getImage();
		String playerAttack = player.getAttack();
		String playerDefense = player.getDefense();

		player2name.setText(playerName);
		player2Image.setImageResource(playerImage);
		player2Country.setImageResource(playerCountryImage);
		player2attack.setText(playerAttack);
		player2defense.setText(playerDefense);
	}

	private void showPlayButton() {
		setVisible(playButton);
	}

	private void showEndScreen() {
		setVisible(endScreen);
	}

	public void endGame(View view) {
		calculatePowersAndSetScores(player1, player2);
		showEndScreen();
		showPlayButton();
	}

}
