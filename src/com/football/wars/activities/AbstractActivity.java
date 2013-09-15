package com.football.wars.activities;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import com.football.wars.sounds.SoundUtils;

public class AbstractActivity extends Activity {

	protected MediaPlayer buttonClick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		buttonClick = SoundUtils.createButtonClickSound(this);
	}

	protected void setVisible(View view) {
		view.setVisibility(View.VISIBLE);
	}

	protected void setInvisible(View view) {
		view.setVisibility(View.INVISIBLE);
	}
}
