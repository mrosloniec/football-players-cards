package com.football.players.cards;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void startNewGame(View view) {
		MediaPlayer buttonClick = MediaPlayer.create(this, R.raw.button_click);
		buttonClick.start();

		Intent intent = new Intent(this, NewGameActivity.class);
		startActivity(intent);
	}
}
