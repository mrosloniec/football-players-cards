package com.football.players.cards.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import com.football.players.cards.R;

public class MainActivity extends Activity {

	private MediaPlayer buttonClick;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		buttonClick = MediaPlayer.create(this, R.raw.button_click);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		buttonClick.release();
	}

	public void startNewGame(View view) {
		makeButtonSoundAndStartActivity(NewGameActivity.class);
	}

	public void viewOptions(View view) {
		makeButtonSoundAndStartActivity(OptionsActivity.class);
	}

	public void viewHowToPlay(View view) {
		makeButtonSoundAndStartActivity(HowToPlayActivity.class);
	}

	public void viewAuthors(View view) {
		makeButtonSoundAndStartActivity(AuthorsActivity.class);
	}

	private void makeButtonSoundAndStartActivity(Class activityClass) {
		buttonClick.start();

		Intent intent = new Intent(this, activityClass);
		startActivity(intent);
	}
}
