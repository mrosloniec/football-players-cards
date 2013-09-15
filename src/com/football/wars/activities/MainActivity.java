package com.football.wars.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.football.wars.R;

public class MainActivity extends AbstractActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
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
